package com.vvsu.mypass.navigation

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import coil.annotation.ExperimentalCoilApi
import com.vvsu.mypass.screens.Customization
import com.vvsu.mypass.screens.Home
import com.vvsu.mypass.screens.Settings
import com.vvsu.mypass.utils.Constants
import com.vvsu.mypass.utils.Screens


@RequiresApi(Build.VERSION_CODES.Q)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun NavigationController() {

    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomNavigation(
                backgroundColor = MaterialTheme.colors.background,
                elevation = 16.dp
            ) {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route

                Screens.Items.items.forEach {
                    BottomNavigationItem(
                        icon = {
                            Icon(imageVector = it.icon, contentDescription = "",tint = if (currentRoute == it.route) Color.DarkGray else Color.LightGray)
                        },
                        selected = currentRoute == it.route,
                        label = {
                            Text(
                                text = it.label,
                                color = if (currentRoute == it.route) Color.DarkGray else Color.LightGray,
                                maxLines = 1,
                                textAlign = TextAlign.Center,
                                fontSize = 10.sp
                            )
                        },
                        onClick = {
                            if (currentRoute != it.route) {
                                navController.graph.startDestinationRoute?.let { item ->
                                    navController.popBackStack(
                                        item, false
                                    )
                                }
                            }
                            if (currentRoute != it.route) {
                                navController.navigate(it.route)
                            }
                        },
                        alwaysShowLabel = false,
                        selectedContentColor = MaterialTheme.colors.secondary,
                    )
                }

            }
        }
    ) {
        ScreenController(
            navController = navController
        )
    }
}

@OptIn(ExperimentalCoilApi::class)
@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun ScreenController(
    navController: NavHostController,
) {
    NavHost(navController = navController, startDestination = Constants.ROUTE_HOME) {
        composable(Constants.ROUTE_HOME) {
            Home()
        }
        composable(Constants.ROUTE_CUSTOMIZATION) {
            Customization()
        }
        composable(Constants.ROUTE_SETTING) {
            Settings()
        }
    }
}