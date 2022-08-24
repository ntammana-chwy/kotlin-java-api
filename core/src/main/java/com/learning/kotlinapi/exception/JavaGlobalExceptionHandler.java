package com.learning.kotlinapi.exception;

import com.learning.kotlinapi.response.JavaErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class JavaGlobalExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(JavaTestException.class)
  public ResponseEntity<JavaErrorResponse> handleTestException(JavaTestException ex) {
    return ResponseEntity.badRequest()
        .body(JavaErrorResponse.builder().errorMessage(ex.getMessage()).errorCode(400).build());
  }
}
