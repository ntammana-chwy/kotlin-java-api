package com.learning.kotlinapi.service

import com.learning.kotlinapi.exception.KotlinTestException
import org.springframework.stereotype.Service

@Service
class KotlinDemoService {
    fun getHelloWorldString(request: String): String =
        when (request) {
            "true" -> "Hello World - ok"
            "false" -> "Hello World - bad request"
            else -> throw KotlinTestException("Something went wrong")
        }
}
