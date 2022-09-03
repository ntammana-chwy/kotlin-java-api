package com.learning.api.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class JavaErrorResponse {
  public String errorMessage;
  public Integer errorCode;

  public JavaRandomResponse toRandomResponse() {
    return JavaRandomResponse.builder().x("x").y("y").z("z").build();
  }
}
