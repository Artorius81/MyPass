package com.vvsu.mypass

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vvsu.mypass.ui.theme.blue69
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily



@Composable
fun Main() {
    val montserrat_light = FontFamily(Font(R.font.montserrat_medium))
    val montserrat_italic = FontFamily(Font(R.font.montserrat_lightitalic))
    val montserrat_bold = FontFamily(Font(R.font.montserrat_medium))
    // val montserrat_regular = FontFamily(Font(R.font.montserrat_regular))
    // val montserrat_extralight = FontFamily(Font(R.font.montserrat_extralight))
    var password by remember { mutableStateOf(("")) }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }
    var text by remember { mutableStateOf(TextFieldValue("")) }
    val paddingModifier = Modifier.padding(10.dp)

    Box(modifier = Modifier
        .fillMaxSize()
        .background(blue69),
    )
    Column(modifier = Modifier
        .padding(30.dp)
        .width(1500.dp)
        .height(102.dp)
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
}