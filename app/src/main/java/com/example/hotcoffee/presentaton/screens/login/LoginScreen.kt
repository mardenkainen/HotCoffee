package com.example.hotcoffee.presentaton.screens.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hotcoffee.presentaton.common.InputTextField
import com.example.hotcoffee.presentaton.common.RoundedButton
import com.example.hotcoffee.presentaton.common.TopBar
import com.example.hotcoffee.ui.theme.HotCoffeeTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(modifier: Modifier = Modifier) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = { TopBar(title = "Логин") },
    ) { innerPadding ->
        Column(
            modifier = modifier
                .padding(innerPadding)
                .padding(horizontal = 18.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            Spacer(modifier = Modifier.fillMaxHeight(0.3f))

            Column(
                modifier = Modifier.align(alignment = Alignment.CenterHorizontally),
                verticalArrangement = Arrangement.spacedBy(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                InputTextField(
                    label = "e-mail",
                    value = email,
                    onValueChange = { email = it },
                    placeholder = "example@example.ru",
                    isPassword = false
                )

                InputTextField(
                    label = "Пароль",
                    value = password,
                    onValueChange = { password = it },
                    placeholder = "******",
                    isPassword = true
                )
            }

            Spacer(modifier = Modifier.height(30.dp))

            RoundedButton("Войти") { }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    HotCoffeeTheme {
        LoginScreen(Modifier.fillMaxSize())
    }
}
