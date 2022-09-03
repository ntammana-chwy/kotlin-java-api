package com.learning.api.service

import com.learning.api.exception.KotlinTestException
import com.learning.api.external.RandomAPIService
import com.learning.api.response.RandomAPIResponse
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
