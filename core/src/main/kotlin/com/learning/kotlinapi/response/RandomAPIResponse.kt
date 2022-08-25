package com.learning.kotlinapi.response

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class RandomAPIResponse(
    val id: Int?,
    val uid: String?,
    val city: String?,
    val streetName: String?,
    val streetAddress: String?,
    val secondaryAddress: String?,
    val buildingNumber: String?,
    val mailBox: String?,
    val community: String?,
    val zipCode: String?,
    val zip: String?,
    val postcode: String?,
    val timeZone: String?,
    val streetSuffix: String?,
    val citySuffix: String?,
    val cityPrefix: String?,
    val state: String?,
    val stateAbbr: String?,
    val country: String?,
    val countryCode: String?,
    val latitude: Double?,
    val longitude: Double?,
    val fullAddress: String? = null
)
