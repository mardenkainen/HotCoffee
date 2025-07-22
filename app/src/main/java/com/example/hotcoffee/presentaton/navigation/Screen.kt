package com.example.hotcoffee.presentaton.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class Screen {
    @Serializable
    object Registration: Screen()
    @Serializable
    object Login: Screen()
    @Serializable
    object Cart: Screen()
    @Serializable
    object Menu: Screen()
    @Serializable
    object CoffeeHousesList: Screen()
    @Serializable
    object Map: Screen()
}
