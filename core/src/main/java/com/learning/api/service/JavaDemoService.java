package com.learning.api.service;

import com.learning.api.exception.JavaTestException;
import org.springframework.stereotype.Service;

@Service
public class JavaDemoService {
  public String getHelloWorldString(String request) throws JavaTestException {
    switch (request) {
      case "true":
        return "Hello World - ok";
      case "false":
        return "Hello World - bad request";
      default:
        throw new JavaTestException("Something went wrong");
    }
  }
}
