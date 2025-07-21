package com.example.hotcoffee.domain.repositories

import com.example.hotcoffee.domain.model.ApiResponse
import com.example.hotcoffee.domain.model.CoffeeHouse
import com.example.hotcoffee.domain.model.MenuPosition
import kotlinx.coroutines.flow.Flow

interface CoffeeHouseRepository {
    fun getCoffeeHouses(): Flow<ApiResponse<List<CoffeeHouse>>>
    fun getMenuPositions(coffeeHouseId: Int): Flow<ApiResponse<List<MenuPosition>>>
}