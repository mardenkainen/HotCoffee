package com.example.hotcoffee.domain.model

data class LoginToken(
    val token: String,
    val tokenLifeTime: Int,
)
