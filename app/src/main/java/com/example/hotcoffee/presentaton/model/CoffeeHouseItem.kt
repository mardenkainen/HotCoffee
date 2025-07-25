package com.example.hotcoffee.presentaton.model

import kotlinx.serialization.Serializable

@Serializable
data class CoffeeHouseItem(
    val id: Int,
    val name: String,
    val distanceToUser: Int
)