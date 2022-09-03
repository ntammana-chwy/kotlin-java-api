package com.learning.api.controller;

import com.learning.api.exception.JavaTestException;
import com.learning.api.service.JavaDemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("java/v1")
@Slf4j
public class JavaDemoController {

  public final JavaDemoService service;

  // Field injection is not recommended -> therefore constructor injection is the more viable
  // approach
  public JavaDemoController(JavaDemoService service) {
    this.service = service;
  }

  @GetMapping("/hello/{status}")
  public ResponseEntity<String> printHello(@PathVariable String status) throws JavaTestException {
    String message = service.getHelloWorldString(status);
    log.info(String.format("Received hello world string %s", message));
    return ResponseEntity.ok().body(message);
  }
}
