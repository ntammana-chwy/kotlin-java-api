package com.learning.api.controller

import com.learning.api.config.Logger
import com.learning.api.response.RandomAPIResponse
import com.learning.api.service.KotlinDemoService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/kotlin/v1")
class KotlinDemoController(private val kotlinDemoService: KotlinDemoService) {

    @GetMapping("/hello/{status}")
    fun printHello(@PathVariable status: String): ResponseEntity<RandomAPIResponse> {
        // Example of chaining functions
        kotlinDemoService.getHelloWorldString(status)
            // "also" is a side effect
            .also { log.info("Got response from kotlin demo service: $it") }
            ?.let { return ResponseEntity.ok().body(it) }
            // Handing nullability
            ?: return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(RandomAPIResponse())
                .also { log.info("RandomApiResponse was null") }
    }

    companion object : Logger()
}
