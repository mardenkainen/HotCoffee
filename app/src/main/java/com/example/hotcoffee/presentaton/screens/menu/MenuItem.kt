package com.example.hotcoffee.presentaton.screens.menu

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
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
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import com.example.hotcoffee.R
import com.example.hotcoffee.presentaton.common.CounterItem
import com.example.hotcoffee.presentaton.common.forwardingPainter
import com.example.hotcoffee.presentaton.model.MenuItem
import com.example.hotcoffee.presentaton.ui.theme.CreamText
import com.example.hotcoffee.presentaton.ui.theme.HotCoffeeTheme
import com.example.hotcoffee.presentaton.ui.theme.PastelGray

@Composable
fun MenuItem(
    menuItem: MenuItem,
    onIncrease: (MenuItem) -> Unit,
    onDecrease: (MenuItem) -> Unit
) {
    val context = LocalContext.current
    val painter = forwardingPainter(
        painter = painterResource(id = R.drawable.coffee_bean),
        colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary)
    )
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(elevation = 2.dp, shape = RoundedCornerShape(12.dp))
            .clip(shape = RoundedCornerShape(12.dp))
            .background(
                color = PastelGray
            ),
        verticalArrangement = Arrangement.Center
    )
    {
        AsyncImage(
            modifier = Modifier
                .aspectRatio(1f)
                .background(CreamText),
            model = ImageRequest.Builder(context).data(menuItem.imageURL).build(),
            contentScale = ContentScale.Crop,
            placeholder = painter,
            error = painter,
            contentDescription = null
        )
        Column(modifier = Modifier.padding(12.dp)) {

            Text(
                modifier = Modifier.wrapContentHeight(),
                text = menuItem.name,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Start,
                color = MaterialTheme.colorScheme.secondary
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier.wrapContentHeight(),
                    text = "${menuItem.price}",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.onSecondaryContainer
                )

                CounterItem(count = menuItem.number, onIncrease = { onIncrease(menuItem) }, onDecrease = { onDecrease(menuItem) })
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MenuItemPreview() {
    HotCoffeeTheme {
        MenuItem(
            menuItem = MenuItem(
                id = 1,
                name = "Coffee",
                imageURL = "",
                price = 100,
                number = 0
            ),
            onDecrease = {},
            onIncrease = {})
    }
}