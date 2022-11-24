package com.vvsu.mypass


import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.vvsu.mypass.ui.theme.MyPassTheme
import com.vvsu.mypass.ui.theme.black
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.runtime.*
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.vvsu.mypass.utils.Constants.ROUTE_CUSTOMIZATION
import com.vvsu.mypass.utils.Constants.ROUTE_HOME
import com.vvsu.mypass.utils.Constants.ROUTE_SETTING
import com.vvsu.mypass.utils.Screens.Items.items


@Suppress("DEPRECATION")
class MainActivity : ComponentActivity() {

    private var backPressedTime: Long = 0
    private val montserrat_light = FontFamily(Font(R.font.montserrat_light))
    private val montserrat_bold = FontFamily(Font(R.font.montserrat_medium))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyPassTheme {
                NavigationController()
            }
        }
    }

    @Composable
    fun Home() {
        val intent = Intent(this, LoginActivity::class.java)

        var isAnimated by remember { mutableStateOf(false) }
        val color = remember { Animatable(Color.DarkGray) }

        LaunchedEffect(isAnimated) {
            color.animateTo(if (isAnimated) Color.White else Color.Red, animationSpec = tween(100))
        }

        Box(modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        )
        Card(
            modifier = Modifier.padding(top=80.dp)
                .fillMaxWidth()
                .padding(20.dp)
                .size(170.dp),
            shape = RoundedCornerShape(15.dp),
            elevation = 10.dp
        ) {}
        Column(
            modifier = Modifier
                .padding(80.dp)
                .width(1400.dp)
                .height(435.dp)
                .fillMaxWidth()
                .wrapContentSize(Alignment.BottomCenter)
        ) {
            Button(
                modifier = Modifier
                    .height(120.dp)
                    .width(230.dp)
                    .padding(30.dp),
                onClick = {
                    isAnimated = !isAnimated
                    //Firebase.auth.signOut()
                    //startActivity(intent)
                },
                border = BorderStroke(1.dp, Color.White),
                shape = RoundedCornerShape(30), // = 30% percent
                colors = ButtonDefaults.outlinedButtonColors(
                    backgroundColor = Color.White,
                ),
            ) {
                Text(
                    text = "Запуск",
                    textAlign = TextAlign.Center,
                    color = black,
                    fontSize = 24.sp,
                    fontFamily = montserrat_bold
                )
            }
        }
    }

    @Composable
    fun Customization() {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = "Информация",
                fontFamily = montserrat_light,
                fontSize = 20.sp)
        }
    }

    @Composable
    fun Settings() {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = "Настройки",
                fontFamily = montserrat_light,
                fontSize = 20.sp
            )
        }
    }

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    @Composable
    fun NavigationController() {

        val navController = rememberNavController()

        Scaffold(
            bottomBar = {
                BottomNavigation(
                    backgroundColor = colors.background,
                    elevation = 16.dp
                ) {
                    val navBackStackEntry by navController.currentBackStackEntryAsState()           //when ever backStack changes it will recompose itself
                    val currentRoute = navBackStackEntry?.destination?.route                        //fetching current backStack entry

                    items.forEach {
                        BottomNavigationItem(
                            icon = {                                                                //bottom nav icon
                                Icon(imageVector = it.icon, contentDescription = "",tint = if (currentRoute == it.route) Color.DarkGray else Color.LightGray)
                            },
                            selected = currentRoute == it.route,                                    //current destination that is visible to user
                            label = {
                                Text(                                                               //bottom nav text
                                    text = it.label,
                                    color = if (currentRoute == it.route) Color.DarkGray else Color.LightGray,
                                    maxLines = 1,
                                    textAlign = TextAlign.Center,
                                    fontSize = 10.sp
                                )
                            },
                            onClick = {
                                if (currentRoute != it.route) {                                     //current route is not equal to same route
                                    navController.graph.startDestinationRoute?.let { item ->        //then handle back press
                                        navController.popBackStack(
                                            item, false
                                        )
                                    }
                                }
                                if (currentRoute != it.route) {                                     //condition to check current route is not equal to screens route
                                    navController.navigate(it.route)
                                }
                            },
                            alwaysShowLabel = false,                                                 // showing/hiding title text
                            selectedContentColor = colors.secondary,                  // ripple color
                        )
                    }

                }
            }
        ) {
            ScreenController(navController = navController)
        }
    }

    @Composable
    fun ScreenController(
        navController: NavHostController
    ) {
        NavHost(navController = navController, startDestination = ROUTE_HOME) {
            composable(ROUTE_HOME) {
                Home()
            }
            composable(ROUTE_CUSTOMIZATION) {
                Customization()
            }
            composable(ROUTE_SETTING) {
                Settings()
            }
        }
    }

    @Deprecated("Deprecated in Java")
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