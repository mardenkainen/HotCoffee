package com.example.hotcoffee.presentaton.screens.coffee_houses_list

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
import com.example.hotcoffee.presentaton.common.RoundedButton
import com.example.hotcoffee.presentaton.common.TopBar
import com.example.hotcoffee.ui.theme.HotCoffeeTheme

@Composable
fun CoffeeHousesScreen(modifier: Modifier = Modifier) {

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = { TopBar(title = "Ближайшие кофейни") { } },
    ) { innerPadding ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 18.dp)
                .padding(bottom = 18.dp),
            verticalArrangement = Arrangement.SpaceBetween ,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            CoffeeHousesList(coffeeHouses = listOf()) {

            }

            RoundedButton("На карте") { }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CoffeeHousesScreenPreview() {
    HotCoffeeTheme {
        CoffeeHousesScreen()
    }
}