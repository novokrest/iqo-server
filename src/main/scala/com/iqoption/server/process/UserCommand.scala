package com.iqoption.server.process

import com.iqoption.server.dto.User
import com.iqoption.server.services.UserService
import org.apache.commons.lang3.StringUtils
import org.slf4j.{Logger, LoggerFactory}
import org.springframework.http.ResponseEntity

class UserCommand(userService: UserService) {

  def execute(user: User): ResponseEntity[String] = {
    if (StringUtils.isNotBlank(user.userId)) {
      userService.addUser(user.userId)
      ResponseEntity.ok(StringUtils.EMPTY)
    } else {
      UserCommand.log.warn("User ID is empty")
      ResponseEntity.badRequest().build()
    }
  }
}

object UserCommand {
  private val log: Logger = LoggerFactory.getLogger(classOf[UserCommand])
}
