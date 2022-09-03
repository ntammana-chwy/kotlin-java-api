package com.learning.api.response

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class RandomAPIResponse(
    val id: Int? = null,
    val uid: String? = null,
    val city: String? = null,
    val streetName: String? = null,
    val streetAddress: String? = null,
    val secondaryAddress: String? = null,
    val buildingNumber: String? = null,
    val mailBox: String? = null,
    val community: String? = null,
    val zipCode: String? = null,
    val zip: String? = null,
    val postcode: String? = null,
    val timeZone: String? = null,
    val streetSuffix: String? = null,
    val citySuffix: String? = null,
    val cityPrefix: String? = null,
    val state: String? = null,
    val stateAbbr: String? = null,
    val country: String? = null,
    val countryCode: String? = null,
    val latitude: Double? = null,
    val longitude: Double? = null,
    val fullAddress: String? = null
)
