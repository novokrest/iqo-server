package com.iqoption.server.process

import com.iqoption.server.services.UserService
import org.springframework.http.ResponseEntity

class StatCommand(userService: UserService) {

  def execute(): ResponseEntity[String] =
    ResponseEntity.ok(userService.getUsersCount().toString)
}
