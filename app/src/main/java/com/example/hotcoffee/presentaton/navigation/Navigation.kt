package com.example.hotcoffee.presentaton.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.hotcoffee.presentaton.screens.cart.CartScreen
import com.example.hotcoffee.presentaton.screens.coffee_house_menu.MenuScreen
import com.example.hotcoffee.presentaton.screens.coffee_houses_list.CoffeeHousesScreen
import com.example.hotcoffee.presentaton.screens.login.LoginScreen
import com.example.hotcoffee.presentaton.screens.map.MapScreen
import com.example.hotcoffee.presentaton.screens.register.RegisterScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Navigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(
        startDestination = Screen.Registration,
        navController = navController
    ) {
        composable<Screen.Registration> {
            RegisterScreen(
                modifier, {
                    navController.navigate(
                        Screen.Login
                    )
                })
        }

        composable<Screen.Login> {
            LoginScreen(modifier)
        }

        composable<Screen.Cart> {
            CartScreen(modifier)
        }

        composable<Screen.Menu> {
            MenuScreen(modifier)
        }

        composable<Screen.CoffeeHousesList> {
            CoffeeHousesScreen(modifier)
        }

        composable<Screen.Map> {
            MapScreen(modifier)
        }
    }


}