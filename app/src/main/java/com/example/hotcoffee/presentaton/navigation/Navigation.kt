package com.example.hotcoffee.presentaton.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.hotcoffee.presentaton.screens.cart.CartScreen
import com.example.hotcoffee.presentaton.screens.cart.CartViewModel
import com.example.hotcoffee.presentaton.screens.coffee_house_menu.MenuScreen
import com.example.hotcoffee.presentaton.screens.coffee_house_menu.MenuViewModel
import com.example.hotcoffee.presentaton.screens.coffee_houses_list.CoffeeHousesScreen
import com.example.hotcoffee.presentaton.screens.coffee_houses_list.CoffeeHousesViewModel
import com.example.hotcoffee.presentaton.screens.login.LoginScreen
import com.example.hotcoffee.presentaton.screens.login.LoginViewModel
import com.example.hotcoffee.presentaton.screens.map.MapScreen
import com.example.hotcoffee.presentaton.screens.map.MapViewModel
import com.example.hotcoffee.presentaton.screens.register.RegisterScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Navigation() {
    val navController = rememberNavController()

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
            val viewModel: CartViewModel = hiltViewModel()
            CartScreen(navController, viewModel)
        }

        composable<Screen.Menu> {
            val viewModel: MenuViewModel = hiltViewModel()
            MenuScreen(navController, viewModel)
        }

        composable<Screen.CoffeeHousesList> {
            val viewModel: CoffeeHousesViewModel = hiltViewModel()
            CoffeeHousesScreen(navController)
        }

        composable<Screen.Map> {
            val viewModel: MapViewModel = hiltViewModel()
            MapScreen(navController, viewModel)
        }
    }


}