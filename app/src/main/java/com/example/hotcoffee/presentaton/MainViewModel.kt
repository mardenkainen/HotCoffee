package com.example.hotcoffee.presentaton

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(): ViewModel() {
    var userIsAuthenticated by mutableStateOf(false)

    fun login() {
        userIsAuthenticated = true
    }
}