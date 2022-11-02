package com.vvsu.mypass

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.rememberNavController
import com.vvsu.mypass.ui.theme.MyPassTheme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.vvsu.mypass.navigation.Screen


class SecondActivity : ComponentActivity() {
    var backPressedTime: Long = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyPassTheme() {
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = Screen.Welcome.route) {
                        composable(Screen.Welcome.route) {
                            Welcome(navController)
                        }
                        composable("main1_screen") {
                            Main()
                        }
                    }
                }
            }
        }
    }
    override fun onBackPressed() {
        if (backPressedTime + 3000 > System.currentTimeMillis()) {
            super.onBackPressed()
            finishAffinity()
        } else {
            Toast.makeText(this, "Нажмите второй раз для выхода из приложения", Toast.LENGTH_LONG).show()
        }
        backPressedTime = System.currentTimeMillis()
    }
}