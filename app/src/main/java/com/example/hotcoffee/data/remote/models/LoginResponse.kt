package com.example.hotcoffee.data.remote.models

data class LoginResponse(
    val token: String,
    val tokenLifeTime: Int
)