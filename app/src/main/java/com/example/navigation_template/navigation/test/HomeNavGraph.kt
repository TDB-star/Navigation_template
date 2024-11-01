package com.example.navigation_template.navigation.test

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.navigation_template.screens.home.Path
import com.example.navigation_template.screens.home.PathType

fun NavGraphBuilder.homeNavGraph(
    homeScreenContent: @Composable () -> Unit,
    pathScreenContent: @Composable (Path) -> Unit
) {

    navigation(
        startDestination = MainNavigationRoute.Main.route, // стартовый экра в данном графе
        route = MainNavigationRoute.Dashboard.route) { // имя вложенного графа

        composable(MainNavigationRoute.Main.route) {
            homeScreenContent()
        }
        composable(MainNavigationRoute.Path.route) { //path_main/{path_name}
            val pathName = it.arguments?.getString("path_name") ?: "no name"
            pathScreenContent(
                Path(
                    name = pathName,
                    type = PathType.MOUSE
                )
            ) // здесь мы получаем объект с главного экрана
        }
    }
}