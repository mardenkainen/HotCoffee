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
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.hotcoffee.presentaton.common.RoundedButton
import com.example.hotcoffee.presentaton.common.TopBar
import com.example.hotcoffee.presentaton.screens.menu.MenuViewModel
import com.example.hotcoffee.presentaton.ui.theme.HotCoffeeTheme

@Composable
fun CartScreen(navController: NavHostController, menuViewModel: MenuViewModel) {

    val cart = menuViewModel.cart.collectAsStateWithLifecycle(listOf())

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { TopBar(title = "Ваш заказ") {
            navController.popBackStack()
        } },
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


            CartItemsList(
                cartItems = cart.value,
                onIncrease = { menuViewModel.addToCart(it) },
                onDecrease = { menuViewModel.removeFromCart(it) })

            RoundedButton("Оплатить") { }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CartScreenPreview() {
    HotCoffeeTheme {
        CartScreen(navController = rememberNavController(), menuViewModel = hiltViewModel())
    }
}