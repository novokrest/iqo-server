package com.iqoption.server

import com.iqoption.server.config.ApplicationConfiguration
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Import

@Import(Array(classOf[ApplicationConfiguration]))
@SpringBootApplication
class Application

object Application extends App {
  SpringApplication.run(classOf[Application])
}
