package com.example.hotcoffee.domain.repositories

import com.example.hotcoffee.domain.model.ApiResponse
import com.example.hotcoffee.domain.model.LoginToken
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    fun login(login: String, password: String): Flow<ApiResponse<LoginToken>>

    fun register(login: String, password: String): Flow<ApiResponse<LoginToken>>
}