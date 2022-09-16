package com.vvsu.mypass

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vvsu.mypass.ui.theme.blue
import com.vvsu.mypass.ui.theme.blue69
import compose.icons.FeatherIcons
import compose.icons.feathericons.Key
import compose.icons.feathericons.LogIn
import compose.icons.feathericons.User


// Экран входа \\

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun LoginScreen() {
    val montserrat_light = FontFamily(Font(R.font.montserrat_medium))
    val montserrat_italic = FontFamily(Font(R.font.montserrat_lightitalic))
    val montserrat_bold = FontFamily(Font(R.font.montserrat_medium))
    val montserrat_regular = FontFamily(Font(R.font.montserrat_regular))
    val montserrat_extralight = FontFamily(Font(R.font.montserrat_extralight))
    var password by remember { mutableStateOf(("")) }
    var text by remember { mutableStateOf(TextFieldValue("")) }
    val keyboardController = LocalSoftwareKeyboardController.current
    val paddingModifier = Modifier.padding(10.dp)
    val widthOnTopBar = "                                                                             "
    val widthOnBottomBar = "                                                 "
    Box(modifier = Modifier
            .fillMaxSize()
            .background(blue),
    )
    Column(modifier = Modifier
        .padding(30.dp)
        .width(1500.dp)
        .height(100.dp)
        .fillMaxWidth()
        .wrapContentSize(Alignment.BottomCenter)) {
        Text(
            modifier = Modifier,
            text = "MyPass",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h4.copy(
                shadow = Shadow(
                    offset = Offset(2f, 2f),
                    blurRadius = 1f
                ),
                color = Color.White,
                fontSize = 45.sp,
                fontFamily = montserrat_bold
            )
        )
    }
    Column(
        modifier = Modifier
            .height(270.dp)
            .fillMaxSize()
            .padding(5.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(shape = RoundedCornerShape(20.dp), elevation = 10.dp, modifier = paddingModifier
            .height(3.dp)) {
            Text(text = widthOnTopBar, modifier = paddingModifier)
        }
    }
    Column(modifier = Modifier
        .padding(30.dp)
        .width(1500.dp)
        .height(240.dp)
        .fillMaxWidth()
        .wrapContentSize(Alignment.Center)) {
        Text(
            modifier = Modifier,
            text = "Ваш пропуск в смартфоне",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h4.copy(
                shadow = Shadow(
                    offset = Offset(2f, 2f),
                    blurRadius = 1f
                ),
                color = Color.White,
                fontSize = 15.sp,
                fontFamily = montserrat_italic
            )
        )
    }
    Column(modifier = Modifier
        .padding(30.dp)
        .width(1500.dp)
        .height(250.dp)
        .fillMaxWidth()
        .wrapContentSize(Alignment.BottomCenter)) {
        OutlinedTextField(
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor=Color.Black,
                backgroundColor = Color.Transparent,
                cursorColor = Color.White,
                focusedBorderColor= Color.White,
                unfocusedBorderColor = Color.White),
            textStyle = TextStyle(fontSize =  20.sp, color = Color.White),
            shape = RoundedCornerShape(25.dp),
            singleLine = true,
            label = {
                Text(
                    text = "Логин",
                    fontFamily = montserrat_light,
                    color = Color.White,
                    fontSize = 17.sp) },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(
                onDone = {keyboardController?.hide()}),
            leadingIcon = { Icon(imageVector = FeatherIcons.User, tint = Color.White, contentDescription = "userIcon") },
            value = text,
            onValueChange = {
                text = it
            }
        )
    }
    Column(
        modifier = Modifier
            .height(600.dp)
            .fillMaxSize()
            .padding(5.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(shape = RoundedCornerShape(20.dp), elevation = 10.dp, modifier = paddingModifier
            .height(3.dp)) {
            Text(text = widthOnBottomBar, modifier = paddingModifier)
        }
    }
    Column(modifier = Modifier
        .padding(30.dp)
        .width(1500.dp)
        .height(350.dp)
        .fillMaxWidth()
        .wrapContentSize(Alignment.BottomCenter)) {
        OutlinedTextField(
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor=Color.Black,
                backgroundColor = Color.Transparent,
                cursorColor = Color.White,
                focusedBorderColor= Color.White,
                unfocusedBorderColor = Color.White),
            textStyle = TextStyle(fontSize =  20.sp, color = Color.White),
            shape = RoundedCornerShape(25.dp),
            singleLine = true,
            label = {
                Text(
                    text = "Пароль",
                    fontFamily = montserrat_light,
                    color = Color.White,
                    fontSize = 17.sp) },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(
                onDone = {keyboardController?.hide()}),
            leadingIcon = { Icon(imageVector = FeatherIcons.Key, tint = Color.White, contentDescription = "passwordIcon") },

            value = password,
            onValueChange = {
                password = it
            }
        )
    }
    Column(modifier = Modifier
        .padding(80.dp)
        .width(1400.dp)
        .height(435.dp)
        .fillMaxWidth()
        .wrapContentSize(Alignment.BottomCenter)) {
        Button(modifier = Modifier.height(120.dp).width(230.dp)
            .padding(30.dp),
            onClick = { },
            border = BorderStroke(1.dp, Color.White),
            shape = RoundedCornerShape(30), // = 30% percent
            // or shape = CircleShape
            colors = ButtonDefaults.outlinedButtonColors(backgroundColor = Color.White, contentColor = Color.White),
        ){
            Text(
                text = "Войти",
                textAlign = TextAlign.Center,
                    color = Color.Black,
                    fontSize = 24.sp,
                    fontFamily = montserrat_bold
                )
            Icon(
                imageVector = FeatherIcons.LogIn,
                contentDescription = "enterIcon",
                modifier = Modifier.padding(top = 4.dp, start = 5.dp),
                tint = Color(0xFF000000)
            )
        }
    }
}


@Preview
@Composable
fun SimpleComposable() {
    LoginScreen()
}