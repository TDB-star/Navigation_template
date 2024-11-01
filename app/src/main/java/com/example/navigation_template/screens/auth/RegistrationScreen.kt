package com.example.navigation_template.screens.auth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun RegistrationScreen(
    onRegisterPressed: () -> Unit,
    onLoginPressed: () -> Unit,
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 35.dp),
    )
    {
        Column(modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {
            Text(text = "Register Screen")
            Button(onClick = { onRegisterPressed()  }) {
                Text(text = "Register")
            }
            Spacer(modifier = Modifier.height(20.dp))
            Button(onClick = { onLoginPressed()  }) {
                Text(text = "Sign in")
            }
        }
    }
}
