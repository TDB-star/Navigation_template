package com.example.navigation_template.navigation.test

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.List
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Star
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.navigation_template.R

sealed class NavigationItem(
    val screen: MainNavigationRoute,
    val titleResId: Int,
    val icon: ImageVector
) {

    object Home: NavigationItem(
        screen = MainNavigationRoute.Dashboard,
        titleResId = R.string.navigation_item_home,
        icon = Icons.Rounded.Home
    )

    object Schools: NavigationItem(
        screen = MainNavigationRoute.SchoolsList,
        titleResId = R.string.navigation_item_schools_list,
        icon = Icons.Rounded.List
    )

    object Crystals: NavigationItem(
        screen = MainNavigationRoute.CrystalsList,
        titleResId = R.string.navigation_item_crystals_list,
        icon = Icons.Rounded.Star
    )

    object Profile: NavigationItem(
        screen = MainNavigationRoute.Profile,
        titleResId = R.string.navigation_item_profile,
        icon = Icons.Rounded.Person
    )
}