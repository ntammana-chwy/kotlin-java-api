package com.learning.kotlinapi.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JavaRandomResponse {
  public String x;
  public String y;
  public String z;

  public JavaRandomResponse(String a, String b, String c) {
    this.x = a;
    this.y = b;
    this.z = c;
  }
}
