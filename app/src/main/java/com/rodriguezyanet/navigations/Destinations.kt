package com.rodriguezyanet.navigations

sealed class Destinations(
    val route: String
) {
    object Splash: Destinations("splash_screen")
    object Home: Destinations("home_screen")
}