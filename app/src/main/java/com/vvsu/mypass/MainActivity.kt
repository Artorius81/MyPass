package com.vvsu.mypass

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.rememberNavController
import com.vvsu.mypass.ui.theme.MyPassTheme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.vvsu.mypass.navigation.Screen


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyPassTheme() {
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = Screen.Splash.route) {
                        composable(Screen.Splash.route) {
                            SplashScreen(navController)
                        }
                        composable("main_screen") {
                            LoginScreen()
                        }
                    }
                }
            }
        }
    }
}