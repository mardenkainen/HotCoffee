package com.example.hotcoffee.presentaton.screens.coffee_houses_list

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hotcoffee.presentaton.model.CoffeeHouseItem
import com.example.hotcoffee.presentaton.ui.theme.HotCoffeeTheme

@Composable
fun CoffeeHouseCard(modifier: Modifier = Modifier, coffeeHouse: CoffeeHouseItem, onClick: () -> Unit) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .shadow(elevation = 2.dp, shape = RoundedCornerShape(6.dp))
            .clickable { onClick() }
            .clip(shape = RoundedCornerShape(6.dp))
            .background(
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
            .padding(8.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            modifier = Modifier.wrapContentHeight(),
            text = coffeeHouse.name,
            fontSize = 18.sp,
            lineHeight = 18.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSecondaryContainer
        )
        Text(
            modifier = Modifier.wrapContentHeight(),
            text = "${coffeeHouse.distanceToUser} м от вас",
            fontSize = 14.sp,
            color = MaterialTheme.colorScheme.secondary
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CoffeeHouseCardPreview() {
    HotCoffeeTheme {
        CoffeeHouseCard(
            coffeeHouse = CoffeeHouseItem(
                id = 1,
                name = "Звездные баксы",
                distanceToUser = 10
            )
        ) { }
    }
}