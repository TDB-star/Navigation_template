package com.example.navigation_template.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun LoginScreen() {


    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp)
                .align(
                    Alignment.Center
                ),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text(text = "Login Screen")
            Spacer(modifier = Modifier.height(24.dp))

            var userName by remember { mutableStateOf("") }
            TextField(
                value = userName,
                onValueChange = { userName = it},
                label = { Text(text = "User name")},
                modifier = Modifier.fillMaxWidth(),
            )
            Spacer(modifier = Modifier.height(16.dp))

            var password by remember { mutableStateOf("") }
            TextField(
                value = password,
                onValueChange = { password = it},
                label = { Text(text = "User name")},
                modifier = Modifier.fillMaxWidth(),
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )
            Spacer(modifier = Modifier.height(24.dp))

            Button(onClick = {  }) {
                Text(text = "LogIn")
            }

            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { }) {
                Text(text = "Go to registration")
            }

            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {  }) {
                Text(text = "Forgot password?")
            }
        }
    }
}