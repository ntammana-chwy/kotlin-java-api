package com.learning.kotlinapi.response

data class KotlinErrorResponse(
  val errorMessage: String,
  var errorCode: Int
)

data class RandomResponse(
  val x: String,
  val y: String,
  val z: String
)

fun KotlinErrorResponse.toRandomResponse() =
  RandomResponse(
    x = this.errorCode.toString(),
    y = this.errorMessage,
    z = "Some random string"
  )

fun KotlinErrorResponse.toRandomString() = "Hello world lol"