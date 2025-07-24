package com.example.hotcoffee.presentaton.screens.coffee_houses_list

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
import com.example.hotcoffee.presentaton.model.CoffeeHouseItem
import com.example.hotcoffee.presentaton.ui.theme.HotCoffeeTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CoffeeHousesList(
    modifier: Modifier = Modifier,
    coffeeHouses: List<CoffeeHouseItem>,
    onClick: (CoffeeHouseItem) -> Unit
) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(vertical = 16.dp)
    ) {
        items(count = coffeeHouses.size) {
            coffeeHouses[it].let { coffeeHouse ->
                CoffeeHouseCard(coffeeHouse = coffeeHouse, onClick = { onClick(coffeeHouse) })
            }
        }
        item { Spacer(modifier = Modifier.padding(100.dp)) }
    }
}

@Preview(showBackground = true)
@Composable
fun CoffeeHousesListPreview() {
    HotCoffeeTheme {
        CoffeeHousesList(
            coffeeHouses = listOf(CoffeeHouseItem(
                id = 1,
                name = "Звездные баксы",
                distanceToUser = 10
            ),
                CoffeeHouseItem(
                id = 1,
                name = "Звездные баксы",
                distanceToUser = 10
            ))
        ) { }
    }
}