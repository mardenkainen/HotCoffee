package com.example.hotcoffee.presentaton.screens.coffee_houses_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hotcoffee.domain.model.ApiResponse
import com.example.hotcoffee.domain.model.CoffeeHouse
import com.example.hotcoffee.domain.repositories.CoffeeHouseRepository
import com.example.hotcoffee.presentaton.model.CoffeeHouseItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoffeeHousesViewModel @Inject constructor(
    private val coffeeHouseRepository: CoffeeHouseRepository
): ViewModel() {
    private val _coffeeHouses = MutableStateFlow(listOf<CoffeeHouseItem>())
    val coffeeHouses = _coffeeHouses.asStateFlow()

    init {
        loadCoffeeHouses()
    }

    fun loadCoffeeHouses() {
        viewModelScope.launch {
            coffeeHouseRepository.getCoffeeHouses().collect { response ->
                when(response) {
                    is ApiResponse.Failure -> {

                    }
                    ApiResponse.Loading -> {

                    }
                    is ApiResponse.Success<List<CoffeeHouse>> -> {
                        _coffeeHouses.value = response.data.map {
                            CoffeeHouseItem(
                                id = it.id,
                                name = it.name,
                                distanceToUser = 1
                            )
                        }
                    }
                }
            }
        }
    }
}