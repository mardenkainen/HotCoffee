package com.example.hotcoffee.data.remote.repositories

import com.example.hotcoffee.data.remote.api.CoffeeApiService
import com.example.hotcoffee.data.remote.apiRequestFlow
import com.example.hotcoffee.data.remote.toCoffeeHouse
import com.example.hotcoffee.data.remote.toMenuPosition
import com.example.hotcoffee.domain.model.ApiResponse
import com.example.hotcoffee.domain.model.CoffeeHouse
import com.example.hotcoffee.domain.model.MenuPosition
import com.example.hotcoffee.domain.repositories.CoffeeHouseRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CoffeeHouseRepositoryImpl @Inject constructor(
    private val coffeeHouseService: CoffeeApiService
) : CoffeeHouseRepository {
    override fun getCoffeeHouses(): Flow<ApiResponse<List<CoffeeHouse>>> = apiRequestFlow {
        coffeeHouseService.getCoffeeHouses()
    }.map { apiResponse -> apiResponse.map { it.map { info -> info.toCoffeeHouse() } } }

    override fun getMenuPositions(coffeeHouseId: Int): Flow<ApiResponse<List<MenuPosition>>> = apiRequestFlow {
        coffeeHouseService.getCoffeeHouseMenu(coffeeHouseId)
    }.map { apiResponse -> apiResponse.map { it.map { item -> item.toMenuPosition() } } }
}