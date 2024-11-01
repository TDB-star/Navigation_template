package com.example.navigation_template.navigation.test

sealed class MainNavigationRoute(
     val route: String
) {

    object Dashboard: MainNavigationRoute(DASHBOARD)
    object Main: MainNavigationRoute(MAIN)
    object Path: MainNavigationRoute(PATH) {

        private const val ROUTE_FOR_ARGS = "main_path"

        fun getRouteWithArgs(path: com.example.navigation_template.screens.home.Path): String {
            return "$ROUTE_FOR_ARGS/${path.name}"
        }
    }
    object CrystalValidation: MainNavigationRoute(CRYSTAL_VALIDATION)

    object CrystalsList: MainNavigationRoute(CRYSTALS_LIST)
    object SchoolsList: MainNavigationRoute(SCHOOLS_LIST)
    object Profile: MainNavigationRoute(PROFILE)


    private companion object {
        const val DASHBOARD = "dashboard_route"
        const val MAIN = "main_route"
        const val PATH = "main_path/{path_name}"

        const val CRYSTAL_VALIDATION = "crystal_validation_route"
        const val CRYSTALS_LIST = "crystals_list_route"
        const val SCHOOLS_LIST = "schools_list_route"
        const val PROFILE = "profile_route"

    }
}

enum class RegisterNavigationRoute(
     val route: String
)  {

    LOGIN_GRAPH("login_graph_route"),

    REGISTER("register_route"),
    LOGIN("login_route"),
    FORGOT_PASSWORD("forgot_password_route"),
}