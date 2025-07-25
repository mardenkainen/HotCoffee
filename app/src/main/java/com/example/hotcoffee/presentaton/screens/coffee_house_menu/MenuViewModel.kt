package com.example.hotcoffee.presentaton.screens.coffee_house_menu

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hotcoffee.domain.model.ApiResponse
import com.example.hotcoffee.domain.model.MenuPosition
import com.example.hotcoffee.domain.repositories.CoffeeHouseRepository
import com.example.hotcoffee.presentaton.model.MenuItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.math.max
import kotlin.math.min

@HiltViewModel
class MenuViewModel @Inject constructor(
    private val coffeeHouseRepository: CoffeeHouseRepository
): ViewModel() {
    private val _menu = MutableStateFlow(listOf<MenuItem>())
    val menu = _menu.asStateFlow()

    fun loadMenu(coffeeHouseId: Int) {
        viewModelScope.launch {
            coffeeHouseRepository.getMenuPositions(coffeeHouseId).collect { response ->
                when(response) {
                    is ApiResponse.Failure -> {

                    }
                    ApiResponse.Loading -> {

                    }
                    is ApiResponse.Success<List<MenuPosition>> -> {
                        _menu.value = response.data.map {
                            MenuItem(
                                id = it.id,
                                name = it.name,
                                imageURL = it.imageURL,
                                price = it.price,
                                number = 0
                            )
                        }
                    }
                }
            }
        }
    }

    fun addToCart(menuItem: MenuItem) {
        Log.d("TAG", "add: $menuItem")
        viewModelScope.launch {
            _menu.value=_menu.value.map { if (it.id == menuItem.id) it.copy(number = it.number + 1) else it }
        }
    }

    fun removeFromCart(menuItem: MenuItem) {
        viewModelScope.launch {
            _menu.emit(_menu.value.map { if (it.id == menuItem.id) it.copy(number = max(it.number - 1,0)) else it })
        }
    }
}