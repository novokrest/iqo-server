package com.iqoption.server.dto

import com.fasterxml.jackson.annotation.JsonProperty

case class User(
  @JsonProperty("user_id") userId: String
)
