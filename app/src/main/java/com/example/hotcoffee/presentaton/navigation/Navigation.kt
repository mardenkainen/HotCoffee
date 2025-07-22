package com.example.hotcoffee.presentaton.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.hotcoffee.presentaton.common.TopBar
import com.example.hotcoffee.presentaton.screens.login.LoginScreen
import com.example.hotcoffee.presentaton.screens.register.RegisterScreen
import com.example.hotcoffee.ui.theme.BorderGray
import com.example.hotcoffee.ui.theme.BrownPrimary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Navigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

        NavHost(
            startDestination = Screen.Registration,
            navController = navController
        ) {
            composable<Screen.Registration> {
                RegisterScreen(Modifier
                    .padding()
                    .fillMaxSize(), {
                    navController.navigate(
                        Screen.Login
                    )
                })
            }

            composable<Screen.Login> {
                LoginScreen(Modifier
                    .padding()
                    .fillMaxSize())
            }

            composable<Screen.Cart> {

            }

            composable<Screen.Menu> {

            }

            composable<Screen.CoffeeHousesList> {

            }

            composable<Screen.Map> {

            }
        }



}