package com.iqoption.server.config

import com.fasterxml.jackson.module.scala.DefaultScalaModule
import com.iqoption.server.process.{StatCommand, UserCommand, VisitController}
import com.iqoption.server.services.UserService
import org.springframework.context.annotation.{Bean, Configuration}
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.transaction.support.TransactionTemplate

@Configuration
class ApplicationConfiguration {

  @Bean
  def userService(jdbcTemplate: JdbcTemplate, txTemplate: TransactionTemplate): UserService = {
    new UserService(jdbcTemplate, txTemplate)
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
