package com.example.hotcoffee.presentaton.screens.menu

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
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.hotcoffee.presentaton.common.RoundedButton
import com.example.hotcoffee.presentaton.common.TopBar
import com.example.hotcoffee.presentaton.navigation.Screen
import com.example.hotcoffee.presentaton.ui.theme.HotCoffeeTheme

@Composable
fun MenuScreen(navController: NavHostController, menuViewModel: MenuViewModel, coffeeHouseId: Int) {
    val menu = menuViewModel.menu.collectAsStateWithLifecycle()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopBar(title = "Меню") {
                navController.popBackStack()
            }
        },
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
                menuItems = menu.value,
                onIncrease = { menuViewModel.addToCart(it) },
                onDecrease = { menuViewModel.removeFromCart(it) })

            RoundedButton("Перейти к оплате") {
                navController.navigate(Screen.Cart)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MenuScreenPreview() {
    HotCoffeeTheme {
        MenuScreen(navController = rememberNavController(), hiltViewModel(), 1)
    }
}