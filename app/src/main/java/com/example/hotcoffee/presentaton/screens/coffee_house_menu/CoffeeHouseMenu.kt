package com.example.hotcoffee.presentaton.screens.coffee_house_menu

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hotcoffee.presentaton.model.MenuItem
import com.example.hotcoffee.presentaton.ui.theme.HotCoffeeTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CoffeeHouseMenu(
    modifier: Modifier = Modifier,
    menuItems: List<MenuItem>,
    onIncrease: (MenuItem) -> Unit,
    onDecrease: (MenuItem) -> Unit
) {
    LazyVerticalGrid(
        modifier = modifier,
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(all = 16.dp)
    ) {
        items(count = menuItems.size) {
            MenuItem(menuItem = menuItems[it], onIncrease = onIncrease, onDecrease = onDecrease)
        }
        item { Spacer(modifier = Modifier.padding(100.dp)) }
    }
}

@Preview(showBackground = true)
@Composable
fun CoffeeHouseMenuPreview() {
    HotCoffeeTheme {
        CoffeeHouseMenu(
            menuItems = listOf(
                MenuItem(
                    id = 1,
                    name = "Coffee",
                    imageURL = "",
                    price = 100,
                    number = 3
                ), MenuItem(
                    id = 2,
                    name = "Coffee2",
                    imageURL = "",
                    price = 200,
                    number = 2
                )
            ), onIncrease = {}, onDecrease = {})
    }
}