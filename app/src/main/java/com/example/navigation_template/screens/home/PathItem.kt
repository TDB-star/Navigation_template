package com.example.navigation_template.screens.home

data class PathItem(
    val type: PathType,
    val image: Int,
    val name: String
)

enum class PathType(
    val type: String
) {
    MOUSE("mouse"),
    ALPINE_SKI("alpineSki"),
    SNOWBOARD("snowboard"),
    FREE_RIDE("freeride"),
    CROSS_COUNTRY("crossCountry")
}