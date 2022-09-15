package com.vvsu.mypass

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun OutLineTextFieldSample() {
    val montserrat_light = FontFamily(Font(R.font.montserrat_medium))
    var text by remember { mutableStateOf(TextFieldValue("")) }
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
            // placeholder = { Text("Логин") },
            textStyle = TextStyle(fontSize =  20.sp, color = Color.White),
            shape = RoundedCornerShape(25.dp),
            singleLine = true,
            label = {
                Text(
                    text = "Логин",
                    fontFamily = montserrat_light,
                    color = Color.White,
                    fontSize = 17.sp) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            value = text,
            onValueChange = {
                text = it
            }
        )
    }
}

@Composable
fun LoginScreen() {
    val paddingModifier = Modifier.padding(10.dp)
    val width = "                                                                             "
    val montserrat_italic = FontFamily(Font(R.font.montserrat_lightitalic))
    val montserrat_bold = FontFamily(Font(R.font.montserrat_medium))
    Image(
        painter = painterResource(id = R.drawable.artboard),
        contentDescription = "background",
        modifier = Modifier
            .size(800.dp)
            .background(Color.LightGray),
        contentScale = ContentScale.FillHeight
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
            Text(text = width, modifier = paddingModifier)
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
}


@Preview
@Composable
fun SimpleComposable() {
    LoginScreen()
}