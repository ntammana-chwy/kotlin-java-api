package com.learning.kotlinapi.external

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.springframework.context.annotation.Configuration
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

@Configuration
class RandomAPIService() {
    fun getApiClient(): RandomAPIClient {
        val baseUrl = "https://random-data-api.com"
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(JacksonConverterFactory.create(jacksonObjectMapper()))
            .build()
        return retrofit.create(RandomAPIClient::class.java)
    }
}
