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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.hotcoffee.presentaton.common.RoundedButton
import com.example.hotcoffee.presentaton.common.TopBar
import com.example.hotcoffee.presentaton.navigation.Screen
import com.example.hotcoffee.presentaton.ui.theme.HotCoffeeTheme

@Composable
fun CoffeeHousesScreen(navController: NavHostController) {
    
    val coffeeHousesViewModel: CoffeeHousesViewModel = hiltViewModel()
    val list = coffeeHousesViewModel.coffeeHouses.collectAsStateWithLifecycle()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { TopBar(title = "Ближайшие кофейни") },
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


            CoffeeHousesList(coffeeHouses = list.value) { coffeeHouseItem ->
                navController.navigate(Screen.Menu(coffeeHouseItem.id))
            }

            RoundedButton("На карте") { }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CoffeeHousesScreenPreview() {
    HotCoffeeTheme {
        CoffeeHousesScreen(navController = rememberNavController())
    }
}