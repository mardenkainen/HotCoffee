package com.example.hotcoffee.data.remote.api

import com.example.hotcoffee.data.remote.models.LocationsResponse
import com.example.hotcoffee.data.remote.models.MenuResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CoffeeApiService {
    @GET("locations")
    suspend fun getCoffeeHouses(): Response<LocationsResponse>


    @GET("location/{id}/menu")
    suspend fun getCoffeeHouseMenu(@Path("id") id: Int): Response<MenuResponse>
}