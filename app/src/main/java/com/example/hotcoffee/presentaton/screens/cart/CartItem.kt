package com.example.hotcoffee.presentaton.screens.cart

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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hotcoffee.presentaton.model.CartItem

@Composable
fun CartItem(modifier: Modifier = Modifier, cartItem: CartItem, onClick: () -> Unit) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .shadow(2.dp)
            .clip(shape = RoundedCornerShape(6.dp))
            .clickable { onClick() }
            .background(
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
            .padding(8.dp),
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
}