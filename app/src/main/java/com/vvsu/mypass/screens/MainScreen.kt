package com.vvsu.mypass.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.vvsu.mypass.R
import com.vvsu.mypass.ui.theme.RedPass
import com.vvsu.mypass.ui.theme.WhiteCard
import com.vvsu.mypass.ui.theme.black
import com.vvsu.mypass.ui.theme.blue69
import compose.icons.FeatherIcons
import compose.icons.feathericons.Camera
import compose.icons.feathericons.Edit2
import compose.icons.feathericons.LogOut
import compose.icons.feathericons.RefreshCw

@ExperimentalCoilApi
@Composable
fun Home() {

    val montserrat_light = FontFamily(Font(R.font.montserrat_light))
    val montserrat_bold = FontFamily(Font(R.font.montserrat_medium))
    val montserrat_italic = FontFamily(Font(R.font.montserrat_lightitalic))
    val montserrat_mediumItalic = FontFamily(Font(R.font.montserrat_mediumitalic))

    Box(modifier = Modifier
        .fillMaxSize()
        .background(WhiteCard)
    )
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
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
            .padding(top = 20.dp)
    ) {
        Card(
            modifier = Modifier
                .padding(top = 60.dp)
                .width(400.dp)
                .padding(20.dp)
                .height(180.dp),
            elevation = 5.dp,
            shape = RoundedCornerShape(12.dp),
        ) {
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(start = 5.dp, top = 10.dp)) {
                Image(
                    painterResource(id = R.drawable.pth1),
                    modifier = Modifier.size(100.dp),
                    contentDescription = null)
                Column(modifier = Modifier)
                {
                    Text(modifier = Modifier,
                        text = "Басов",
                        color = black,
                        fontSize = 18.sp,
                        fontFamily = montserrat_bold
                    )
                    Text(modifier = Modifier,
                        text = "Данил",
                        color = black,
                        fontSize = 18.sp,
                        fontFamily = montserrat_bold
                    )
                    Text(modifier = Modifier,
                        text = "Геннадьевич",
                        color = black,
                        fontSize = 18.sp,
                        fontFamily = montserrat_bold
                    )
                    Text(modifier = Modifier,
                        text = "Студент",
                        color = blue69,
                        fontSize = 18.sp,
                        fontFamily = montserrat_mediumItalic
                    )
                }
            }
            Row(modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End) {
                Image(
                    painterResource(id = R.drawable.vectorpaint__1_),
                    modifier = Modifier
                        .width(100.dp)
                        .rotate(90f),
                    contentDescription = null)
            }
        }
        Button(
            modifier = Modifier
                .height(120.dp)
                .width(230.dp)
                .padding(30.dp),
            onClick = {  },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
            shape = RoundedCornerShape(16), // = 30% percent
        ) {
            Text(
                text = "Начать",
                textAlign = TextAlign.Center,
                color = black,
                fontSize = 28.sp,
                fontFamily = montserrat_bold
            )
        }
    }
}

@Composable
fun Customization() {

    val montserrat_light = FontFamily(Font(R.font.montserrat_light))
    val montserrat_bold = FontFamily(Font(R.font.montserrat_medium))
    val montserrat_italic = FontFamily(Font(R.font.montserrat_lightitalic))
    val montserrat_mediumItalic = FontFamily(Font(R.font.montserrat_mediumitalic))

    Box(modifier = Modifier
        .fillMaxSize()
        .background(WhiteCard))

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp, start = 20.dp)
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
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 100.dp)
    ) {
        Card(
            shape = RoundedCornerShape(8.dp),
            backgroundColor = Color.White,
            modifier = Modifier
                .padding(10.dp)
                .width(300.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
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
                        onClick = {  },
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
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 180.dp)
    ) {
        Card(
            shape = RoundedCornerShape(8.dp),
            backgroundColor = Color.White,
            modifier = Modifier
                .padding(10.dp)
                .width(300.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
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
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 60.dp)
    ) {
        Card(
            shape = RoundedCornerShape(8.dp),
            backgroundColor = Color.White,
            modifier = Modifier
                .padding(10.dp)
                .width(300.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
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

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun Settings() {

    val montserrat_light = FontFamily(Font(R.font.montserrat_light))
    val montserrat_bold = FontFamily(Font(R.font.montserrat_medium))
    val montserrat_italic = FontFamily(Font(R.font.montserrat_lightitalic))
    val montserrat_mediumItalic = FontFamily(Font(R.font.montserrat_mediumitalic))

    Box(modifier = Modifier
        .fillMaxSize()
        .background(WhiteCard))

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp, start = 20.dp)
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
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 70.dp)
    ) {
        Card(
            shape = RoundedCornerShape(8.dp),
            backgroundColor = Color.White,
            modifier = Modifier
                .width(300.dp)
                .height(70.dp)
        ) {
            Row(modifier = Modifier.padding(start = 10.dp, end = 10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween) {
                Text(
                    text = "Выйти из MyPass",
                    color = RedPass,
                    fontFamily = montserrat_bold,
                    fontSize = 16.sp
                )
                IconButton(
                    onClick = {
                        Firebase.auth.signOut() },
                    modifier = Modifier.background(
                        color = RedPass,
                        shape = RoundedCornerShape(10.dp)
                    )
                ) {
                    Icon(FeatherIcons.LogOut,
                        modifier = Modifier.size(24.dp),
                        tint = Color.White,
                        contentDescription = null)
                }
            }
        }
        Card(
            shape = RoundedCornerShape(8.dp),
            backgroundColor = Color.White,
            modifier = Modifier
                .padding(top = 10.dp)
                .width(300.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
            ) {
                Text(
                    text = "ВВГУ 2023",
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