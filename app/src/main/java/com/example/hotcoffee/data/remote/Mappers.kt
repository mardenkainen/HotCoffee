package com.example.hotcoffee.data.remote

import com.example.hotcoffee.data.remote.models.CoffeeHouseInfo
import com.example.hotcoffee.data.remote.models.LoginResponse
import com.example.hotcoffee.data.remote.models.MenuItem
import com.example.hotcoffee.domain.model.CoffeeHouse
import com.example.hotcoffee.domain.model.LoginToken
import com.example.hotcoffee.domain.model.MenuPosition

fun LoginResponse.toLoginToken() = LoginToken(
    token = token,
    tokenLifeTime = tokenLifeTime
)

fun CoffeeHouseInfo.toCoffeeHouse() = CoffeeHouse(
    id = id,
    name = name,
    latitude = point.latitude.toString(),
    longitude = point.longitude.toString()
)

fun MenuItem.toMenuPosition() = MenuPosition(
    name = name,
    price = price,
    imageURL = imageURL,
)