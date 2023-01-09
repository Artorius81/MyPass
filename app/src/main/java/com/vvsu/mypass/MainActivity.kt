package com.vvsu.mypass


import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.ButtonDefaults.buttonColors
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
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
import com.google.firebase.database.ktx.database
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestoreSettings
import com.google.firebase.ktx.Firebase
import com.vvsu.mypass.ui.theme.*
import com.vvsu.mypass.utils.Constants.ROUTE_CUSTOMIZATION
import com.vvsu.mypass.utils.Constants.ROUTE_HOME
import com.vvsu.mypass.utils.Constants.ROUTE_SETTING
import com.vvsu.mypass.utils.Screens.Items.items
import compose.icons.FeatherIcons
import compose.icons.feathericons.*


@Suppress("DEPRECATION")
class MainActivity : ComponentActivity() {

    private var backPressedTime: Long = 0
    private val montserrat_light = FontFamily(Font(R.font.montserrat_light))
    private val montserrat_bold = FontFamily(Font(R.font.montserrat_medium))
    private val montserrat_italic = FontFamily(Font(R.font.montserrat_lightitalic))
    private val montserrat_mediumItalic = FontFamily(Font(R.font.montserrat_mediumitalic))

    private val rootRef = FirebaseDatabase.getInstance().reference
    private val uid = FirebaseAuth.getInstance().currentUser!!.uid
    private val uidRef = rootRef.child("users").child(uid)

    override fun onCreate(savedInstanceState: Bundle?) {
        setPersistance()
        super.onCreate(savedInstanceState)
        setContent {
            MyPassTheme {

                NavigationController()

            }
        }
    }

    @ExperimentalCoilApi
    @Composable
    fun Home(userName: String, userSurname: String, userPatronymic: String, userPhoto: String, userSpecialty: String, userCourse: String, userDegree: String, userDepartment: String) {

        Box(modifier = Modifier
            .fillMaxSize()
            .background(WhiteCard))

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 20.dp, start = 20.dp)
        ) {
            Row(modifier = Modifier) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "Пропуск",
                        color = black,
                        fontFamily = montserrat_bold,
                        fontSize = 24.sp
                    )
                }
            }
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 20.dp, start = 200.dp)
        ) {
            Row(modifier = Modifier) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = if (userName == "Ксения") "Доцент" else "Студент",
                        color = blue69,
                        fontSize = 24.sp,
                        fontFamily = montserrat_bold
                    )
                }
            }
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
            Divider(
                color = blue69,
                modifier = Modifier
                    .padding(start = 260.dp, end = 20.dp)
                    .width(1.dp)
            )
            Column(modifier = Modifier
                .padding(start = 262.dp, end = 20.dp)
                .width(100.dp).height(120.dp)
                .fillMaxWidth()
            ) {
                Image(
                    painterResource(R.drawable.logo_white),
                    contentDescription = "vvsu_logo",
                    modifier = Modifier.requiredSize(35.dp)
                )
            }
            Column(modifier = Modifier
                .padding(start = 10.dp, top = 10.dp)
                .width(100.dp).height(120.dp)
                .fillMaxWidth()
            ) {
                SubcomposeAsyncImage(
                    model = userPhoto,
                    contentDescription = null,
                    loading = {
                        CircularProgressIndicator(
                            modifier = Modifier.size(1.dp).width(1.dp),
                            color = blue69,
                            strokeWidth = 3.dp
                        )
                    },
                    modifier = Modifier
                        .requiredSize(70.dp)
                        .clip(RoundedCornerShape(20))
                )
            }
            Column(modifier = Modifier.fillMaxWidth()
            ) {
                Text(modifier = Modifier.padding(start = 80.dp, top = 13.dp),
                    text = userSurname,
                    color = black,
                    fontSize = 16.sp,
                    fontFamily = montserrat_bold
                )
                Text(modifier = Modifier.padding(start = 80.dp, top = 0.5.dp),
                    text = userName,
                    color = black,
                    fontSize = 16.sp,
                    fontFamily = montserrat_bold
                )
                Text(modifier = Modifier.padding(start = 80.dp, top = 0.5.dp),
                    text = userPatronymic,
                    color = black,
                    fontSize = 16.sp,
                    fontFamily = montserrat_bold
                )
                Text(modifier = Modifier.padding(start = 10.dp, top = 6.dp),
                    text = if (userName == "Ксения") "Кафедра" else "Специальность",
                    color = black,
                    fontSize = 13.sp,
                    fontFamily = montserrat_bold
                )
                Text(modifier = Modifier.padding(start = 10.dp),
                    text = if (userName == "Ксения") userDepartment else userSpecialty,
                    color = black,
                    fontSize = 12.sp,
                    fontFamily = montserrat_italic
                )
                Text(modifier = Modifier.padding(start = 10.dp, top = 4.dp),
                    text = if (userName == "Ксения") "Учёная степень" else "Группа",
                    color = black,
                    fontSize = 13.sp,
                    fontFamily = montserrat_bold
                )
                Text(modifier = Modifier.padding(start = 10.dp),
                    text = if (userName == "Ксения") userDegree else userCourse,
                    color = black,
                    fontSize = 12.sp,
                    fontFamily = montserrat_italic
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
                onClick = {},
                colors = buttonColors(backgroundColor = Color.White),
                shape = RoundedCornerShape(30), // = 30% percent
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

        var imageUri: Any? by remember { mutableStateOf(R.drawable.icon) }
        val photoPicker = rememberLauncherForActivityResult(
            contract = ActivityResultContracts.PickVisualMedia()
        ) {
            if (it != null) {
                imageUri = it
            }
        }

        Box(modifier = Modifier.fillMaxSize().background(WhiteCard))

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize().padding(top = 20.dp, start = 20.dp)
        ) {
            Row(modifier = Modifier) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "Кастомизация",
                        color = black,
                        fontFamily = montserrat_bold,
                        fontSize = 24.sp
                    )
                }
            }
        }

        Column(
            //verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize().padding(top = 80.dp)
        ) {
            Card(
                shape = RoundedCornerShape(14.dp),
                elevation = 10.dp,
                backgroundColor = Color.White,
                modifier = Modifier.padding(10.dp).width(290.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth().padding(10.dp),
                ) {
                    Row(modifier = Modifier) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = "Сменить фото профиля",
                                color = black,
                                fontFamily = montserrat_bold,
                                fontSize = 15.sp
                            )
                            Text(
                                text = "Выбрать фото из галереи",
                                color = black,
                                fontFamily = montserrat_italic,
                                fontSize = 10.sp
                                )

                        }
                        IconButton(
                            onClick = {
                                photoPicker.launch(
                                    PickVisualMediaRequest(
                                        ActivityResultContracts.PickVisualMedia.ImageOnly
                                    )
                                )
                            },
                            modifier = Modifier.background(
                                color = blue69,
                                shape = RoundedCornerShape(10.dp)
                            )
                        ) {
                            Icon(FeatherIcons.Camera, tint = Color.White,  contentDescription = null)
                        }
                    }
                }
            }
        }

        Column(
            //verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize().padding(top = 160.dp)
        ) {
            Card(
                shape = RoundedCornerShape(14.dp),
                elevation = 10.dp,
                backgroundColor = Color.White,
                modifier = Modifier.padding(10.dp).width(290.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth().padding(10.dp),
                ) {
                    Row(modifier = Modifier) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = "Сменить фон пропуска",
                                color = black,
                                fontFamily = montserrat_bold,
                                fontSize = 15.sp
                            )
                            Text(
                                text = "Выбрать цвет из палитры",
                                color = black,
                                fontFamily = montserrat_italic,
                                fontSize = 10.sp
                            )

                        }
                        IconButton(
                            onClick = { },
                            modifier = Modifier.background(
                                color = blue69,
                                shape = RoundedCornerShape(10.dp)
                            )
                        ) {
                            Icon(FeatherIcons.Edit2, tint = Color.White,  contentDescription = null)
                        }
                    }
                }
            }
        }

        Column(
            //verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize().padding(top = 450.dp)
        ) {
            Card(
                shape = RoundedCornerShape(14.dp),
                elevation = 10.dp,
                backgroundColor = Color.White,
                modifier = Modifier.padding(10.dp).width(290.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth().padding(10.dp),
                ) {
                    Row(modifier = Modifier) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = "Сбросить дизайн",
                                color = RedPass,
                                fontFamily = montserrat_bold,
                                fontSize = 15.sp
                            )
                            Text(
                                text = "Вернёт дизайн по-умолчанию",
                                color = RedPass,
                                fontFamily = montserrat_italic,
                                fontSize = 10.sp
                            )

                        }
                        IconButton(
                            onClick = { },
                            modifier = Modifier.background(
                                color = RedPass,
                                shape = RoundedCornerShape(10.dp)
                            )
                        ) {
                            Icon(FeatherIcons.RefreshCw, tint = Color.White,  contentDescription = null)
                        }
                    }
                }
            }
        }
    }

    @Composable
    fun Settings() {
        val intent = Intent(this, LoginActivity::class.java)

        Box(modifier = Modifier.fillMaxSize().background(WhiteCard))

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize().padding(top = 20.dp, start = 20.dp)
        ) {
            Row(modifier = Modifier) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "Настройки",
                        color = black,
                        fontFamily = montserrat_bold,
                        fontSize = 24.sp
                    )
                }
            }
        }

        Column(
            //verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize().padding(top = 360.dp)
        ) {
            Card(
                shape = RoundedCornerShape(14.dp),
                elevation = 10.dp,
                backgroundColor = Color.White,
                modifier = Modifier.padding(10.dp).width(290.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth().padding(10.dp),
                ) {
                    Row(modifier = Modifier) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = "Выйти из MyPass",
                                color = RedPass,
                                fontFamily = montserrat_bold,
                                fontSize = 15.sp
                            )
                        }
                        IconButton(
                            onClick = {
                                Firebase.auth.signOut()
                                startActivity(intent)
                            },
                            modifier = Modifier.background(
                                color = RedPass,
                                shape = RoundedCornerShape(10.dp)
                            )
                        ) {
                            Icon(FeatherIcons.LogOut, tint = Color.White,  contentDescription = null)
                        }
                    }
                }
            }
        }
        Column(
            //verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize().padding(top = 500.dp)
        ) {
            Card(
                shape = RoundedCornerShape(14.dp),
                elevation = 10.dp,
                backgroundColor = Color.White,
                modifier = Modifier.padding(10.dp).width(290.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth().padding(10.dp),
                ) {
                    Row(modifier = Modifier) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = "ВВГУ 2022",
                                color = blue69,
                                fontFamily = montserrat_bold,
                                fontSize = 15.sp
                            )
                            Text(
                                text = "      ",
                                color = black,
                                fontFamily = montserrat_light,
                                fontSize = 13.sp
                            )
                            Text(
                                text = "По всем вопросам Вы можете обратиться в тех.поддержку:",
                                color = black,
                                fontFamily = montserrat_light,
                                fontSize = 13.sp
                            )
                            Text(
                                fontFamily = montserrat_light,
                                fontSize = 13.sp,
                                text = buildAnnotatedString {
                                    append("ауд. ")

                                    pushStyle(style = SpanStyle(color = black, fontFamily = montserrat_bold))
                                    append("1600, ")
                                    pop()

                                    append("тел ")

                                    pushStyle(style = SpanStyle(color = black, fontFamily = montserrat_bold))
                                    append("8 (423) 240-40-14")
                                    pop()
                                },
                            )
                        }
                    }
                }
            }
        }
    }

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    @Composable
    private fun NavigationController() {

        val navController = rememberNavController()

        var userName by rememberSaveable { mutableStateOf("") }
        var userSurname by rememberSaveable { mutableStateOf("") }
        var userPatronymic by rememberSaveable { mutableStateOf("") }
        var userPhoto by rememberSaveable { mutableStateOf("") }
        var userSpecialty by rememberSaveable { mutableStateOf("") }
        var userCourse by rememberSaveable { mutableStateOf("") }
        var userDegree by rememberSaveable { mutableStateOf("") }
        var userDepartment by rememberSaveable { mutableStateOf("") }

        uidRef.get().addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val snapshot = task.result
                userName = snapshot?.child("name")?.getValue(String::class.java)!!
                userSurname = snapshot.child("surname").getValue(String::class.java)!!
                userPatronymic = snapshot.child("patronymic").getValue(String::class.java)!!
                userPhoto = snapshot.child("photo_url").getValue(String::class.java)!!
                userSpecialty = snapshot.child("specialty").getValue(String::class.java)!!
                userCourse = snapshot.child("course").getValue(String::class.java)!!
                userDegree = snapshot.child("degree").getValue(String::class.java)!!
                userDepartment = snapshot.child("department").getValue(String::class.java)!!
            }
        }

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
                userPhoto = userPhoto,
                userSpecialty = userSpecialty,
                userCourse = userCourse,
                userDegree = userDegree,
                userDepartment = userDepartment
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
        userPhoto: String,
        userSpecialty: String,
        userCourse: String,
        userDegree: String,
        userDepartment: String
    ) {
        NavHost(navController = navController, startDestination = ROUTE_HOME) {
            composable(ROUTE_HOME) {
                Home(userName, userSurname, userPatronymic, userPhoto, userSpecialty, userCourse, userDegree, userDepartment)
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

    private fun setPersistance() {

        val db = FirebaseFirestore.getInstance()

        val settings = firestoreSettings {
            isPersistenceEnabled = true
        }
        db.firestoreSettings = settings

    }
}