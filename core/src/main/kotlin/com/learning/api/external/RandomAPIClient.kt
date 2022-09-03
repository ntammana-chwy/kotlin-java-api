package com.learning.api.external

import com.learning.api.response.RandomAPIResponse
import retrofit2.Call
import retrofit2.http.GET

interface RandomAPIClient {
    @GET("api/address/random_address")
    fun getRandomAddress(): Call<RandomAPIResponse>
}
