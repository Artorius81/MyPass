package com.vvsu.mypass.navigation

sealed class Screen(val route: String) {
    object Splash : Screen("splash_screen")
    object Login : Screen("main_screen")
    object Welcome : Screen("welcome_screen")
    object Main : Screen("main1_screen")
}