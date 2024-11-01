package com.example.navigation_template

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.navigation_template.screens.home.MainScreenTest
import com.example.navigation_template.screens.home.path.PathScreenTest
import com.example.navigation_template.ui.theme.Navigation_templateTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Navigation_templateTheme {
                //PathScreenTest()
                MainScreenTest()

            }
        }
    }
}

