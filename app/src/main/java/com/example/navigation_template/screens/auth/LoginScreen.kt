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
fun LoginScreen(
    onRegisterPressed: () -> Unit,
    onLoginPressed: () -> Unit,
    onForgotPasswordPressed: () -> Unit,
    onResendEmailPressed: () -> Unit
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
            Text(text = "Login Screen")
            Button(onClick = { onLoginPressed()  }) {
                Text(text = "login")
            }
            Spacer(modifier = Modifier.height(20.dp))
            Button(onClick = { onRegisterPressed()  }) {
                Text(text = "Sign up")
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp, top = 20.dp)) {
                TextButton(onClick = { onForgotPasswordPressed() }) {
                    Text(text = "Forgot password")
                }

                TextButton(onClick = { onResendEmailPressed() }) {
                    Text(text = "Resend email")
                }
            }
        }
    }
}
