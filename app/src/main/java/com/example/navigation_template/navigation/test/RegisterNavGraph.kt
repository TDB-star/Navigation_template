package com.example.navigation_template.navigation.test

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation

@Composable
fun NavGraphBuilder.registerGraph(
    loginScreenContent: @Composable () -> Unit,
    registerScreenContent: @Composable () -> Unit,
    forgotPasswordScreenContent: @Composable () -> Unit,
) {

    navigation(
        startDestination = RegisterNavigationRoute.LOGIN.route,
        route = RegisterNavigationRoute.LOGIN_GRAPH.route
    ) {
        composable(RegisterNavigationRoute.LOGIN.route) {
            loginScreenContent()
        }
        composable(RegisterNavigationRoute.FORGOT_PASSWORD.route) {
            forgotPasswordScreenContent()
        }
    }

    composable(RegisterNavigationRoute.REGISTER.route) {
        registerScreenContent()
    }
}