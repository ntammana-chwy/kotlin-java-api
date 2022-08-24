package com.learning.kotlinapi.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JavaErrorResponse {
  public String errorMessage;
  public Integer errorCode;

  public JavaErrorResponse(String message, Integer code) {
    this.errorCode = code;
    this.errorMessage = message;
  }

  public JavaRandomResponse toRandomResponse() {
    return JavaRandomResponse.builder().x("x").y("y").z("z").build();
  }
}
