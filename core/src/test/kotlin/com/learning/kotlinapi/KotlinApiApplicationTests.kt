package com.learning.kotlinapi

import com.learning.kotlinapi.response.RandomAPIResponse
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.server.LocalServerPort
import org.springframework.http.HttpEntity
import org.springframework.http.HttpMethod
import org.springframework.http.MediaType
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.reactive.server.WebTestClient

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles(value = ["test"])
@AutoConfigureWebTestClient
class KotlinApiApplicationTests(
    @Autowired val testRestTemplate: TestRestTemplate,
    @Autowired private val webClient: WebTestClient
) {

    @LocalServerPort
    private val serverPort = 0

    @Test
    fun testKotlinController() {

        // Test Rest Template approach
        val response = testRestTemplate.exchange(
            "/kotlin/v1/hello/true",
            HttpMethod.GET,
            HttpEntity.EMPTY,
            RandomAPIResponse::class.java
        )

        response shouldNotBe null
        response.body?.id shouldNotBe null

        // Web Test Client approach
        webClient.get()
            .uri("/kotlin/v1/hello/true")
            .accept(MediaType.APPLICATION_JSON)
            .header("Content-Type", "application/json")
            .exchange()
            .expectBody(RandomAPIResponse::class.java)
            .consumeWith { it.responseBody?.id shouldNotBe null }
            .returnResult()
    }

    @Test
    fun testJavaController() {

        // Test Rest Template approach
        val response = testRestTemplate.exchange(
            "/java/v1/hello/true",
            HttpMethod.GET,
            HttpEntity.EMPTY,
            String::class.java
        )

        response shouldNotBe null
        response.body shouldBe "Hello World - ok"

        // Web Test Client approach
        webClient.get()
            .uri("/java/v1/hello/true")
            .accept(MediaType.APPLICATION_JSON)
            .header("Content-Type", "application/json")
            .exchange()
            .expectBody(String::class.java)
            .consumeWith { it.responseBody shouldBe "Hello World - ok" }
            .returnResult()
    }
}
