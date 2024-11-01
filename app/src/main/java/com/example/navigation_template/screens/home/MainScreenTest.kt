package com.example.navigation_template.screens.home

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.navigation_template.navigation.test.MainNavigationRoute
import com.example.navigation_template.navigation.test.AppNavGraph
import com.example.navigation_template.navigation.test.NavigationItem
import com.example.navigation_template.screens.CrystalsListScreen
import com.example.navigation_template.screens.ProfileListScreen
import com.example.navigation_template.screens.SchoolsListScreen
import com.example.navigation_template.screens.home.path.PathScreen

@Composable
fun MainScreenTest() {

   val navHostController = rememberNavController()

    val userId = "1"

    Scaffold(
        contentWindowInsets = WindowInsets(10.dp),
        bottomBar = {

            NavigationBar {

                val navBackStackEntry by navHostController.currentBackStackEntryAsState()

                val items = listOf(
                    NavigationItem.Home,
                    NavigationItem.Schools,
                    NavigationItem.Crystals,
                    NavigationItem.Profile
                )

                items.forEach { item ->
                    val selected = navBackStackEntry?.destination?.hierarchy?.any {
                        it.route == item.screen.route
                    } ?: false

                    NavigationBarItem(
                        selected = selected,
                        onClick = {
                            if (!selected) {
                                navHostController.navigate(item.screen.route) {
                                    popUpTo(navHostController.graph.findStartDestination().id) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                                  },
                        icon = { Icon(imageVector = item.icon, contentDescription = null) },
                        label = { Text(text = stringResource(id = item.titleResId)) }
                    )
                }
            }
        }
        ) { paddingValues ->

        AppNavGraph(
            navHostController = navHostController,
            homeScreenContent = {
                MainScreen(
                    onPathClick = {
                        navHostController.navigate(MainNavigationRoute.Path.getRouteWithArgs(Path()))
                    },
                    userId = userId
                )
            },
            schoolsScreenContent = { SchoolsListScreen() },
            crystalsScreenContent = { CrystalsListScreen() },
            profileScreenContent = { ProfileListScreen() },
            pathScreenContent = { path ->
                PathScreen(
                    onBackPressed = {
                        navHostController.popBackStack()
                    },
                    path = path, skier = Skier(0))
            },
       )
    }
}
