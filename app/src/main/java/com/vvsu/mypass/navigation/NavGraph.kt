package com.vvsu.mypass.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.vvsu.mypass.SplashScreen
import com.vvsu.mypass.Welcome


@Composable
fun SetupNavGraph(navController: NavHostController) {
    navController.popBackStack()
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {
        composable(route = Screen.Splash.route) {
            SplashScreen(navController = navController)
        }
        composable(route = Screen.Login.route) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White),
            )
            navController.popBackStack()
        }
        composable(route = Screen.Welcome.route) {
            Welcome(navController = navController)
        }
        composable(route = Screen.Main.route) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White),
            )
            navController.popBackStack()
        }
    }
}