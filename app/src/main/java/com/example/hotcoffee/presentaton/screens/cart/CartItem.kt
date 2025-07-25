package com.example.hotcoffee.presentaton.screens.cart

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import com.example.hotcoffee.presentaton.common.CounterItem
import com.example.hotcoffee.presentaton.model.MenuItem
import com.example.hotcoffee.presentaton.ui.theme.HotCoffeeTheme

@Composable
fun CartItem(
    modifier: Modifier = Modifier,
    cartItem: MenuItem,
    onIncrease: (MenuItem) -> Unit,
    onDecrease: (MenuItem) -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .shadow(2.dp)
            .clip(shape = RoundedCornerShape(6.dp))
            .background(
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                modifier = Modifier.wrapContentHeight(),
                text = cartItem.name,
                fontSize = 18.sp,
                lineHeight = 18.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSecondaryContainer
            )
            Text(
                modifier = Modifier.wrapContentHeight(),
                text = "${cartItem.price}",
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.secondary
            )
        }
        CounterItem(
            count = cartItem.number,
            onIncrease = { onIncrease(cartItem) },
            onDecrease = { onDecrease(cartItem) })

    }
}

@Preview(showBackground = true)
@Composable
fun CartItemPreview() {
    HotCoffeeTheme {
        CartItem(
            cartItem = MenuItem(
                id = 1,
                name = "Coffee",
                imageURL = "",
                price = 100,
                number = 0
            ),
            onDecrease = {},
            onIncrease = {}
        )
    }
}