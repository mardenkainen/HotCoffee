package com.example.hotcoffee.presentaton.screens.coffee_house_menu

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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.hotcoffee.data.remote.models.MenuItem
import com.example.hotcoffee.presentaton.common.RoundedButton
import com.example.hotcoffee.presentaton.common.TopBar
import com.example.hotcoffee.presentaton.screens.cart.CartViewModel
import com.example.hotcoffee.presentaton.ui.theme.HotCoffeeTheme

@Composable
fun MenuScreen(navController: NavHostController, menuViewModel: MenuViewModel) {

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { TopBar(title = "Меню") { } },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 8.dp)
                .padding(bottom = 8.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            CoffeeHouseMenu(
                menuItems = listOf(
                    MenuItem(
                        id = 1,
                        name = "Coffee",
                        imageURL = "",
                        price = 100
                    ), MenuItem(
                        id = 2,
                        name = "Coffee2",
                        imageURL = "",
                        price = 200
                    )
                )
            ) {

            }

            RoundedButton("Перейти к оплате") { }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MenuScreenPreview() {
    HotCoffeeTheme {
        MenuScreen(navController = rememberNavController(), hiltViewModel())
    }
}