package com.iqoption.server.services

import org.slf4j.{Logger, LoggerFactory}
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.transaction.support.TransactionTemplate

class UserService(jdbcTemplate: JdbcTemplate, txTemplate: TransactionTemplate) {

  def addUser(userName: String): Unit = {
    if (isNewUser(userName)) {
      UserService.log.info("User is new: user={}", userName)
      storeUser(userName)
    } else {
      UserService.log.info("User already exists: user={}", userName)
    }
  }

  private def isNewUser(userName: String): Boolean = {
    jdbcTemplate.queryForObject("SELECT COUNT(1) FROM user WHERE name = ?", classOf[Int], userName) == 0
  }

  private def storeUser(userName: String): Unit = {
    UserService.log.info("Try to store new user: user={}", userName)
    val updateCount: Int = txTemplate.execute(_ => jdbcTemplate.update(s"INSERT OR REPLACE INTO user (name) VALUES (?)", userName))
    if (updateCount == 1) {
      UserService.log.info("User was stored: user={}", userName)
    } else {
      UserService.log.warn("Failed to store user: user={}", userName)
    }
  }

  def getUsersCount(): Int = {
    val usersCount = jdbcTemplate.queryForObject("SELECT COUNT(1) FROM user", classOf[Int])
    UserService.log.debug("There are the following number of users: count={}", usersCount)
    usersCount
  }
}

object UserService {
  private val log: Logger = LoggerFactory.getLogger(classOf[UserService])
}