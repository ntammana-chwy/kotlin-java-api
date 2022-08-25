package com.learning.kotlinapi.service

import com.learning.kotlinapi.exception.KotlinTestException
import com.learning.kotlinapi.external.RandomAPIService
import com.learning.kotlinapi.response.RandomAPIResponse
import org.springframework.stereotype.Service

@Service
class KotlinDemoService(private val randomAPIService: RandomAPIService) {
    fun getHelloWorldString(request: String): RandomAPIResponse? {
        return when (request) {
            "true" -> randomAPIService.getApiClient().getRandomAddress().execute().body()
            "false" -> null
            else -> throw KotlinTestException("Something went wrong")
        }
    }
}
