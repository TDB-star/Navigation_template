package com.example.navigation_template.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier


@Composable
fun RegisterScreen() {


    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "Registration")
        Button(onClick = {  }) {
            Text(text = "Go back")
        }
    }
}