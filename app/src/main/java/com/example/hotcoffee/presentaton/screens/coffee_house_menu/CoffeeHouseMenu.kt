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
import androidx.compose.ui.unit.dp
import com.example.hotcoffee.data.remote.models.MenuItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CoffeeHouseMenu(
    modifier: Modifier = Modifier,
    menuItems: List<MenuItem>,
    onClick: (MenuItem) -> Unit
) {
    LazyVerticalGrid(
        modifier = modifier,
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(all = 16.dp)
    ) {
        items(count = menuItems.size) {
            menuItems[it].let { menuItem ->
                MenuItem(menuItem = menuItem, onClick = { onClick(menuItem) })
            }
        }
        item { Spacer(modifier = Modifier.padding(100.dp)) }
    }
}