package com.iqoption.server.process

import com.iqoption.server.dto.User
import org.springframework.http.{MediaType, ResponseEntity}
import org.springframework.web.bind.annotation._

@RestController
class VisitController(userCommand: UserCommand, statCommand: StatCommand) {

  @PostMapping(
    value = Array("/user"),
    consumes = Array(MediaType.APPLICATION_JSON_UTF8_VALUE),
    produces = Array(MediaType.TEXT_PLAIN_VALUE))
  def user(@RequestBody user: User): ResponseEntity[String] = userCommand.execute(user)

  @GetMapping(
    value = Array("/stat"),
    produces = Array(MediaType.TEXT_PLAIN_VALUE))
  def stat(): ResponseEntity[String] = statCommand.execute()
}
