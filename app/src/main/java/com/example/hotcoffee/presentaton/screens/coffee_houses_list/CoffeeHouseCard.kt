package com.example.hotcoffee.presentaton.screens.coffee_houses_list

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hotcoffee.presentaton.model.CoffeeHouse
import com.example.hotcoffee.ui.theme.HotCoffeeTheme

@Composable
fun CoffeeHouseCard(modifier: Modifier = Modifier, coffeeHouse: CoffeeHouse, onClick: () -> Unit) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(12.dp))
            .clickable { onClick() }
            .background(
                color = MaterialTheme.colorScheme.secondaryContainer,
                shape = RoundedCornerShape(12.dp)
            ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.wrapContentHeight(),
            text = coffeeHouse.name,
            minLines = 2,
            fontSize = 18.sp,
            lineHeight = 18.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
        )
        Spacer(modifier = Modifier.padding(12.dp))
        Text(
            modifier = Modifier.wrapContentHeight(),
            text = "Расстояние до вас: ${coffeeHouse.distanceToUser}",
            minLines = 2,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CoffeeHouseCardPreview() {
    HotCoffeeTheme {
        CoffeeHouseCard(
            coffeeHouse = CoffeeHouse(
                id = 1,
                name = "Звездные баксы",
                distanceToUser = 10
            )
        ) { }
    }
}