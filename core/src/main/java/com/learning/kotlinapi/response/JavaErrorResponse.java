package com.learning.kotlinapi.response;

import lombok.Data;

@Data
public class JavaErrorResponse {
  public String errorMessage;
  public Integer errorCode;

  public JavaErrorResponse(String message, Integer code) {
    this.errorCode = code;
    this.errorMessage = message;
  }
}
