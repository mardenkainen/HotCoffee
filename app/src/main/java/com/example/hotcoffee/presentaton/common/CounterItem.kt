package com.example.hotcoffee.presentaton.common

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.hotcoffee.presentaton.ui.theme.CreamText
import com.example.hotcoffee.presentaton.ui.theme.HotCoffeeTheme

@Composable
fun CounterItem(
    modifier: Modifier = Modifier,
    count: Int = 0
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        IconButton(onClick = { }) {
            Text(
                text = "–",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = CreamText
            )
        }

        Text(
            text = "$count",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )

        IconButton(onClick = { }) {
            Text(
                text = "+",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = CreamText
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CounterItemPreview() {
    HotCoffeeTheme {
        CounterItem()
    }
}