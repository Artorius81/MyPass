package com.vvsu.mypass


import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
<<<<<<< HEAD
import androidx.annotation.RequiresApi
=======
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
>>>>>>> parent of b5ad695 (Improved version)
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
<<<<<<< HEAD
import com.vvsu.mypass.navigation.NavigationController
import com.vvsu.mypass.ui.theme.*
import compose.icons.feathericons.*
=======
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import coil.annotation.ExperimentalCoilApi
import coil.compose.SubcomposeAsyncImage
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase
import com.vvsu.mypass.ui.theme.MyPassTheme
import com.vvsu.mypass.ui.theme.blue69
import com.vvsu.mypass.utils.Constants.ROUTE_CUSTOMIZATION
import com.vvsu.mypass.utils.Constants.ROUTE_HOME
import com.vvsu.mypass.utils.Constants.ROUTE_SETTING
import com.vvsu.mypass.utils.Screens.Items.items
>>>>>>> parent of b5ad695 (Improved version)


@Suppress("DEPRECATION")
class MainActivity : ComponentActivity() {

    private var backPressedTime: Long = 0
<<<<<<< HEAD
=======
    private val montserrat_light = FontFamily(Font(R.font.montserrat_light))
    private val montserrat_bold = FontFamily(Font(R.font.montserrat_medium))

    private val rootRef = FirebaseDatabase.getInstance().reference
    private val uid = FirebaseAuth.getInstance().currentUser!!.uid
    private val uidRef = rootRef.child("users").child(uid)
>>>>>>> parent of b5ad695 (Improved version)

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyPassTheme {
<<<<<<< HEAD
                NavigationController()
=======

                var userName by rememberSaveable { mutableStateOf("") }
                var userSurname by rememberSaveable { mutableStateOf("") }
                var userPatronymic by rememberSaveable { mutableStateOf("") }
                var userPhoto by rememberSaveable { mutableStateOf("") }

                uidRef.get().addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val snapshot = task.result
                        userName = snapshot?.child("name")?.getValue(String::class.java)!!
                        userSurname = snapshot.child("surname").getValue(String::class.java)!!
                        userPatronymic = snapshot.child("patronymic").getValue(String::class.java)!!
                        userPhoto = snapshot.child("photo_url").getValue(String::class.java)!!
                    }
                }
                NavigationController(
                    userName,
                    userSurname,
                    userPatronymic,
                    userPhoto
                )
>>>>>>> parent of b5ad695 (Improved version)
            }
        }
    }

<<<<<<< HEAD
=======
    @ExperimentalCoilApi
    @Composable
    fun Home(userName: String, userSurname: String, userPatronymic: String, userPhoto: String) {
        val interactionSource = remember { MutableInteractionSource() }

        var selected_color by remember { mutableStateOf(false) }
        val color = if (selected_color) Color.Red else Color.White

        var selected_text by remember { mutableStateOf(false) }
        val text = if (selected_text) Color.White else Color.Black

        val run = if (text == Color.White) "Стоп" else "Запуск"


        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
        )
        Card(
            modifier = Modifier
                .padding(top = 80.dp)
                .fillMaxWidth()
                .padding(20.dp)
                .size(170.dp),
            shape = RoundedCornerShape(15.dp),
            elevation = 10.dp
        ) {
            Divider(
                color = blue69,
                modifier = Modifier
                    .padding(start = 240.dp, end = 20.dp)
                    .width(1.dp)
            )
            Column(modifier = Modifier
                .padding(start = 242.dp, end = 20.dp)
                .width(100.dp)
                .height(120.dp)
                .fillMaxWidth()
            ) {
                Image(
                    painterResource(R.drawable.logo_white),
                    contentDescription = "vvsu_logo",
                    modifier = Modifier.requiredSize(55.dp)
                )
            }
            Column(modifier = Modifier
                .padding(start = 10.dp, top = 10.dp)
                .width(100.dp)
                .height(120.dp)
                .fillMaxWidth()
            ) {
                SubcomposeAsyncImage(
                    model = userPhoto,
                    contentDescription = null,
                    loading = {
                        CircularProgressIndicator(
                            modifier = Modifier.size(1.dp).width(4.dp),
                            color = blue69,
                            strokeWidth = 3.dp
                        )
                    },
                    modifier = Modifier.requiredSize(70.dp).clip(RoundedCornerShape(20))
                )
            }
            Column(modifier = Modifier
                .fillMaxWidth()
            ) {
                Text(modifier = Modifier
                    .padding(start = 80.dp, top = 15.dp),
                    text = userSurname,
                    color = Color.Black,
                    fontSize = 15.sp,
                    fontFamily = montserrat_bold
                )
                Text(modifier = Modifier
                    .padding(start = 80.dp, top = 0.5.dp),
                    text = userName,
                    color = Color.Black,
                    fontSize = 15.sp,
                    fontFamily = montserrat_bold
                )
                Text(modifier = Modifier
                    .padding(start = 80.dp, top = 0.5.dp),
                    text = userPatronymic,
                    color = Color.Black,
                    fontSize = 15.sp,
                    fontFamily = montserrat_bold
                )
                Text(modifier = Modifier
                    .padding(start = 10.dp, top = 10.dp),
                    text = "Студент",
                    color = blue69,
                    fontSize = 15.sp,
                    fontFamily = montserrat_bold
                )
            }
        }
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
                    selected_color = !selected_color
                    selected_text = !selected_text
                },
                interactionSource = interactionSource,
                colors = buttonColors(backgroundColor = color),
                shape = RoundedCornerShape(30), // = 30% percent
            ) {
                Text(
                    text = run,
                    textAlign = TextAlign.Center,
                    color = text,
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
                text = "Изменить",
                fontFamily = montserrat_light,
                fontSize = 20.sp
            )
        }
    }

    @Composable
    fun Settings() {
        val intent = Intent(this, LoginActivity::class.java)

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
        Card(
            modifier = Modifier
                .padding(top = 80.dp)
                .fillMaxWidth()
                .padding(20.dp)
                .size(170.dp),
            shape = RoundedCornerShape(15.dp),
            elevation = 10.dp
        ) {
            Button(
                modifier = Modifier
                    .height(120.dp)
                    .width(230.dp)
                    .padding(30.dp),
                colors = ButtonDefaults.outlinedButtonColors(
                    backgroundColor = Color.White
                ),
                onClick = {
                    Firebase.auth.signOut()
                    startActivity(intent)
                },
                shape = RoundedCornerShape(30), // = 30% percent
            ) {
                Text(
                    text = "Выйти из учётной записи",
                    textAlign = TextAlign.Center,
                    color = Color.Black,
                    fontSize = 17.sp,
                    fontFamily = montserrat_bold
                )
            }
        }
    }

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    @Composable
    private fun NavigationController(userName: String, userSurname: String, userPatronymic: String, userPhoto: String) {

        val navController = rememberNavController()

        Scaffold(
            bottomBar = {
                BottomNavigation(
                    backgroundColor = colors.background,
                    elevation = 16.dp
                ) {
                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                    val currentRoute = navBackStackEntry?.destination?.route

                    items.forEach {
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
                            selectedContentColor = colors.secondary,
                        )
                    }

                }
            }
        ) {
            ScreenController(
                navController = navController,
                userName = userName,
                userSurname = userSurname,
                userPatronymic = userPatronymic,
                userPhoto = userPhoto
            )
        }
    }

    @OptIn(ExperimentalCoilApi::class)
    @Composable
    fun ScreenController(
        navController: NavHostController,
        userName: String,
        userSurname: String,
        userPatronymic: String,
        userPhoto: String
    ) {
        NavHost(navController = navController, startDestination = ROUTE_HOME) {
            composable(ROUTE_HOME) {
                Home(userName, userSurname, userPatronymic, userPhoto)
            }
            composable(ROUTE_CUSTOMIZATION) {
                Customization()
            }
            composable(ROUTE_SETTING) {
                Settings()
            }
        }
    }

>>>>>>> parent of b5ad695 (Improved version)
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