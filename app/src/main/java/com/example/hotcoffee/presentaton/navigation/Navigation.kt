package com.example.hotcoffee.presentaton.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.hotcoffee.presentaton.screens.cart.CartScreen
import com.example.hotcoffee.presentaton.screens.menu.MenuViewModel
import com.example.hotcoffee.presentaton.screens.coffee_houses_list.CoffeeHousesScreen
import com.example.hotcoffee.presentaton.screens.coffee_houses_list.CoffeeHousesViewModel
import com.example.hotcoffee.presentaton.screens.login.LoginScreen
import com.example.hotcoffee.presentaton.screens.map.MapScreen
import com.example.hotcoffee.presentaton.screens.map.MapViewModel
import com.example.hotcoffee.presentaton.screens.menu.MenuScreen
import com.example.hotcoffee.presentaton.screens.register.RegisterScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Navigation() {
    val navController = rememberNavController()

    val menuViewModel: MenuViewModel = hiltViewModel()

    NavHost(
        startDestination = Screen.Login,
        navController = navController
    ) {
        composable<Screen.Registration> {
            RegisterScreen(navController = navController)
        }

        composable<Screen.Login> {
            LoginScreen(navController)
        }

        composable<Screen.Cart> {
            CartScreen(navController, menuViewModel)
        }

        composable<Screen.Menu> { backStackEntry ->
            val menu: Screen.Menu = backStackEntry.toRoute()
            MenuScreen(navController, menuViewModel, menu.coffeeHouseId)
        }

        composable<Screen.CoffeeHousesList> {
            CoffeeHousesScreen(navController)
        }

        composable<Screen.Map> {
            val viewModel: MapViewModel = hiltViewModel()
            MapScreen(navController, viewModel)
        }
    }


}