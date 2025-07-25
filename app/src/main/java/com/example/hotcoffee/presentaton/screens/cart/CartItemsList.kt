package com.example.hotcoffee.presentaton.screens.cart

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hotcoffee.presentaton.model.MenuItem
import com.example.hotcoffee.presentaton.ui.theme.HotCoffeeTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartItemsList(
    modifier: Modifier = Modifier,
    cartItems: List<MenuItem>,
    onIncrease: (MenuItem) -> Unit,
    onDecrease: (MenuItem) -> Unit
) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(vertical = 16.dp)
    ) {
        items(count = cartItems.size) { it
            CartItem(cartItem = cartItems[it], onIncrease = onIncrease, onDecrease = onDecrease)
        }
        item { Spacer(modifier = Modifier.padding(100.dp)) }
    }
}

@Preview(showBackground = true)
@Composable
fun CoffeeHousesListPreview() {
    HotCoffeeTheme {
        CartItemsList(
            cartItems = listOf(
                MenuItem(
                    id = 1,
                    name = "Coffee",
                    imageURL = "",
                    price = 100,
                    number = 0
                ),
                MenuItem(
                    id = 1,
                    name = "Coffee",
                    imageURL = "",
                    price = 100,
                    number = 0
                )
            ),
            onIncrease = {},
            onDecrease = {}
        )
    }
}