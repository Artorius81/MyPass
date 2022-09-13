package com.vvsu.mypass.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.vvsu.mypass.R
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontStyle

private val Montserrat = FontFamily(
    Font(R.font.montserrat_medium),
    Font(R.font.montserrat_italic, style = FontStyle.Italic),
    Font(R.font.montserrat_light, weight = FontWeight.Light),
    Font(R.font.montserrat_bold, weight = FontWeight.Bold),
    Font(R.font.montserrat_black, weight = FontWeight.Black),
)

val Typography = Typography(
    defaultFontFamily = Montserrat
)