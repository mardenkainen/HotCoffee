package com.example.hotcoffee.presentaton.screens.cart

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.hotcoffee.presentaton.common.RoundedButton
import com.example.hotcoffee.presentaton.common.TopBar
import com.example.hotcoffee.presentaton.screens.coffee_house_menu.CoffeeHouseMenu
import com.example.hotcoffee.presentaton.ui.theme.HotCoffeeTheme

@Composable
fun CartScreen(navController: NavHostController, viewModel: CartViewModel) {

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { TopBar(title = "Ваш заказ") { } },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 18.dp)
                .padding(bottom = 18.dp),
            verticalArrangement = Arrangement.SpaceBetween ,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            /*CoffeeHouseMenu(menuItems = listOf()) {

            }*/

            RoundedButton("Оплатить") { }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CartScreenPreview() {
    HotCoffeeTheme {
        CartScreen(navController = rememberNavController(), viewModel = hiltViewModel())
    }
}