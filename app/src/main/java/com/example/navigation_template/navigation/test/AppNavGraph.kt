package com.example.navigation_template.navigation.test

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.navigation_template.screens.home.Path

@Composable
fun AppNavGraph(
    navHostController: NavHostController,
    homeScreenContent: @Composable () -> Unit,
    pathScreenContent: @Composable (Path) -> Unit,
    schoolsScreenContent: @Composable () -> Unit,
    crystalsScreenContent: @Composable () -> Unit,
    profileScreenContent: @Composable () -> Unit
    ) {
    
    NavHost(
        navController = navHostController,
        startDestination = MainNavigationRoute.Dashboard.route,
    ) {

        homeNavGraph(
            homeScreenContent = homeScreenContent,
            pathScreenContent = pathScreenContent
        )
        composable(MainNavigationRoute.SchoolsList.route) {
            schoolsScreenContent()
        }
        composable(MainNavigationRoute.CrystalsList.route) {
            crystalsScreenContent()
        }
        composable(MainNavigationRoute.Profile.route) {
            profileScreenContent()
        }
    }
}

