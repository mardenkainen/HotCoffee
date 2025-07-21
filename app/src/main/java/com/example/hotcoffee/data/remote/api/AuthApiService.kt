package com.example.hotcoffee.data.remote.api

import com.example.hotcoffee.data.remote.models.Auth
import com.example.hotcoffee.data.remote.models.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApiService {
    @POST("auth/login")
    suspend fun login(
        @Body auth: Auth,
    ): Response<LoginResponse>

    @POST("auth/register")
    suspend fun register(
        @Body auth: Auth,
    ): Response<LoginResponse>
}