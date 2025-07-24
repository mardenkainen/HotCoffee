package com.example.hotcoffee.presentaton.screens.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hotcoffee.data.local.TokenManager
import com.example.hotcoffee.domain.model.ApiResponse
import com.example.hotcoffee.domain.model.LoginToken
import com.example.hotcoffee.domain.repositories.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    val authRepository: AuthRepository,
    private val tokenManager: TokenManager
) : ViewModel() {
    private val _userIsLogged = MutableStateFlow(false)
    val userIsLogged = _userIsLogged.asStateFlow()
    fun login(name: String, password: String) {
        viewModelScope.launch {
            authRepository.login(name, password).collect { response ->
                when (response) {
                    is ApiResponse.Failure -> {

                    }
                    ApiResponse.Loading -> {

                    }
                    is ApiResponse.Success<LoginToken> -> {
                        tokenManager.saveToken(response.data.token)
                        _userIsLogged.value = true
                    }
                }
            }
        }
    }
}