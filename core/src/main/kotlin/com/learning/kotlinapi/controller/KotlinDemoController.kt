package com.learning.kotlinapi.controller

import com.learning.kotlinapi.service.KotlinDemoService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/kotlin/v1")
class KotlinDemoController(
    private val kotlinDemoService: KotlinDemoService
) {

    @GetMapping("/hello/{status}")
    fun printHello(@PathVariable status: String): ResponseEntity<String> {
        return kotlinDemoService.getHelloWorldString(status)
            .let { ResponseEntity.ok().body(it) }
    }
}
