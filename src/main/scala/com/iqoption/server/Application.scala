package com.iqoption.server

import com.iqoption.server.config.ApplicationConfiguration
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Import

@Import(Array(classOf[ApplicationConfiguration]))
@SpringBootApplication
class Application

object Application {
  def main(args: Array[String]): Unit = {
    SpringApplication.run(classOf[Application], args: _*)
  }
}
