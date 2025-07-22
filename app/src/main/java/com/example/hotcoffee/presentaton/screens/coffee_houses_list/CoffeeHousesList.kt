package com.example.hotcoffee.presentaton.screens.coffee_houses_list

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
import com.example.hotcoffee.presentaton.model.CoffeeHouse

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharactersList(
    modifier: Modifier = Modifier,
    coffeeHouses: List<CoffeeHouse>,
    onClick: (CoffeeHouse) -> Unit
) {
    LazyVerticalGrid(
        modifier = modifier,
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(all = 16.dp)
    ) {
        items(count = coffeeHouses.size) {
            coffeeHouses[it].let { coffeeHouse ->
                CoffeeHouseCard(coffeeHouse = coffeeHouse, onClick = { onClick(coffeeHouse) })
            }
        }
        item { Spacer(modifier = Modifier.padding(100.dp)) }
    }

}