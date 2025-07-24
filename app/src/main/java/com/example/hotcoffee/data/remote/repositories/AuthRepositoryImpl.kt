package com.example.hotcoffee.data.remote.repositories

import com.example.hotcoffee.data.remote.api.AuthApiService
import com.example.hotcoffee.data.remote.apiRequestFlow
import com.example.hotcoffee.data.remote.models.Auth
import com.example.hotcoffee.data.remote.toLoginToken
import com.example.hotcoffee.domain.repositories.AuthRepository
import com.example.hotcoffee.domain.model.ApiResponse
import com.example.hotcoffee.domain.model.LoginToken
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class AuthRepositoryImpl(
    private val authService: AuthApiService
) : AuthRepository {
    override fun login(login: String, password: String) = apiRequestFlow {
        authService.login(Auth(login = login, password = password))
    }.map { apiResponse -> apiResponse.map { it.toLoginToken() } }

    override fun register(login: String, password: String): Flow<ApiResponse<LoginToken>> =
        apiRequestFlow {
            authService.register(Auth(login = login, password = password))
        }.map { apiResponse -> apiResponse.map { it.toLoginToken() } }
}