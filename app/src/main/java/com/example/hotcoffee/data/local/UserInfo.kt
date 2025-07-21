package com.example.hotcoffee.data.local

import kotlinx.serialization.Serializable

@Serializable
data class UserInfo(
    val login: String,
    val password: String
)
