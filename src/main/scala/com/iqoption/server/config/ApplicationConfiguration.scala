package com.iqoption.server.config

import com.fasterxml.jackson.module.scala.DefaultScalaModule
import com.iqoption.server.process.{StatCommand, UserCommand, VisitController}
import com.iqoption.server.services.UserService
import org.springframework.context.annotation.{Bean, Configuration, Import}
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.transaction.support.TransactionTemplate

@Import(value = Array(classOf[StorageConfiguration]))
@Configuration
class ApplicationConfiguration {

  @Bean
  def userService(masterJdbcTemplate: JdbcTemplate,
                  masterTransactionTemplate: TransactionTemplate,
                  slaveJdbcTemplate: JdbcTemplate): UserService = {
    new UserService(masterJdbcTemplate, masterTransactionTemplate, slaveJdbcTemplate)
  }

  @Bean
  def userCommand(userService: UserService): UserCommand = {
    new UserCommand(userService)
  }

  @Bean
  def statCommand(userService: UserService): StatCommand = {
    new StatCommand(userService)
  }

  @Bean
  def visitController(userCommand: UserCommand, statCommand: StatCommand): VisitController = {
    new VisitController(userCommand, statCommand)
  }

  @Bean
  def jacksonBuilder: Jackson2ObjectMapperBuilder = {
    new Jackson2ObjectMapperBuilder()
      .modulesToInstall(classOf[DefaultScalaModule])
  }
}
