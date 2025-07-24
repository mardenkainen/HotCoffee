package com.example.hotcoffee.presentaton.screens.register

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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.hotcoffee.presentaton.common.InputTextField
import com.example.hotcoffee.presentaton.common.RoundedButton
import com.example.hotcoffee.presentaton.common.TopBar
import com.example.hotcoffee.presentaton.navigation.Screen
import com.example.hotcoffee.presentaton.ui.theme.HotCoffeeTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(navController: NavController) {
    val registerViewModel: RegisterViewModel =  hiltViewModel()
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var confirmPassword by rememberSaveable { mutableStateOf("") }
    val userIsLogged by registerViewModel.userIsLogged.collectAsStateWithLifecycle()

    LaunchedEffect(key1 = userIsLogged) {
        if (userIsLogged) {
            navController.navigate(Screen.CoffeeHousesList) {
                popUpTo(Screen.Registration) { inclusive = true }
            }
        }
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { TopBar(title = "Регистрация") },
    ) { innerPadding ->

        Column(
            modifier = Modifier
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

            Spacer(modifier = Modifier.height(24.dp))

            InputTextField(
                label = "Повторите пароль",
                value = confirmPassword,
                onValueChange = { confirmPassword = it },
                placeholder = "******",
                isPassword = true
            )

            Spacer(modifier = Modifier.height(30.dp))

            RoundedButton(
                text = "Регистрация",
                onClick = { registerViewModel.register(email, password, confirmPassword) }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RegisterScreenPreview() {
    HotCoffeeTheme {
        RegisterScreen(rememberNavController())
    }
}
