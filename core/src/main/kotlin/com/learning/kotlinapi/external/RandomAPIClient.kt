package com.learning.kotlinapi.external

import com.learning.kotlinapi.response.RandomAPIResponse
import retrofit2.Call
import retrofit2.http.GET

interface RandomAPIClient {
    @GET("api/address/random_address")
    fun getRandomAddress(): Call<RandomAPIResponse>
}
