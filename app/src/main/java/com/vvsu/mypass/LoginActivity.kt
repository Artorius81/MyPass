package com.vvsu.mypass

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.ButtonDefaults.buttonColors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.*
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vvsu.mypass.ui.theme.MyPassTheme
import com.vvsu.mypass.ui.theme.blue69
import compose.icons.FeatherIcons
import compose.icons.feathericons.Key
import compose.icons.feathericons.LogIn
import compose.icons.feathericons.User
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily


class LoginActivity : ComponentActivity() {

    @OptIn(ExperimentalComposeUiApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyPassTheme() {
                val intent = Intent(this, WelcomeActivity::class.java)
                val montserrat_light = FontFamily(Font(R.font.montserrat_medium))
                val montserrat_italic = FontFamily(Font(R.font.montserrat_lightitalic))
                val montserrat_bold = FontFamily(Font(R.font.montserrat_medium))
                var password by remember { mutableStateOf(("")) }
                var passwordVisible by rememberSaveable { mutableStateOf(false) }
                var text by remember { mutableStateOf(TextFieldValue("")) }
                val keyboardController = LocalSoftwareKeyboardController.current
                val paddingModifier = Modifier.padding(10.dp)
                val widthOnTopBar = "                                                         "
                val widthOnBottomBar = "                                                 "
                val uriHandler = LocalUriHandler.current
                val context = LocalContext.current
                val intentVk = remember { Intent(Intent.ACTION_VIEW, Uri.parse("https://vk.com/vvsu_dv")) }
                val intentTg = remember { Intent(Intent.ACTION_VIEW, Uri.parse("https://t.me/vvsuru")) }
                val annotatedLinkStringPassword: AnnotatedString = buildAnnotatedString {

                    val forgetPassword = "Забыли пароль?"
                    val startIndex = forgetPassword.indexOf("Забыли пароль?")
                    val endIndex = startIndex + 14
                    append(forgetPassword)
                    addStyle(
                        style = SpanStyle(
                            color = Color(0xFFFFFFFF),
                            shadow = Shadow(
                                offset = Offset(2f, 2f),
                                blurRadius = 1f
                            ),
                            fontSize = 18.sp,
                        ), start = startIndex, end = endIndex
                    )
                    addStringAnnotation(
                        tag = "URL_Pass",
                        annotation = "https://api.vvsu.ru/services/changepass",
                        start = startIndex,
                        end = endIndex
                    )
                    addStringAnnotation(
                        tag = "URL_Reg",
                        annotation = "https://www.vvsu.ru/registration/",
                        start = startIndex,
                        end = endIndex
                    )
                }
                val annotatedLinkStringReg: AnnotatedString = buildAnnotatedString {

                    val registration = "Регистрация"
                    val startIndex = registration.indexOf("Регистрация")
                    val endIndex = startIndex + 11
                    append(registration)
                    addStyle(
                        style = SpanStyle(
                            color = Color(0xFFFFFFFF),
                            shadow = Shadow(
                                offset = Offset(2f, 2f),
                                blurRadius = 1f
                            ),
                            fontSize = 18.sp,
                        ), start = startIndex, end = endIndex
                    )
                    addStringAnnotation(
                        tag = "URL_Pass",
                        annotation = "https://api.vvsu.ru/services/changepass",
                        start = startIndex,
                        end = endIndex
                    )
                    addStringAnnotation(
                        tag = "URL_Reg",
                        annotation = "https://www.vvsu.ru/registration/",
                        start = startIndex,
                        end = endIndex
                    )
                }
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
                Column(
                    modifier = Modifier
                        .height(270.dp)
                        .fillMaxSize()
                        .padding(5.dp),
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Card(shape = RoundedCornerShape(20.dp), elevation = 10.dp, modifier = paddingModifier
                        .height(2.dp)) {
                        Text(text = widthOnTopBar, modifier = paddingModifier)
                    }
                }
                Column(modifier = Modifier
                    .padding(25.dp)
                    .width(1500.dp)
                    .height(245.dp)
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

                // Password TextField part \\

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
                        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password,
                            imeAction = ImeAction.Done),
                        keyboardActions = KeyboardActions(
                            onDone = {keyboardController?.hide()}),
                        leadingIcon = { Icon(imageVector = FeatherIcons.Key, tint = Color.White, contentDescription = "passwordIcon") },
                        trailingIcon = {
                            val image = if (passwordVisible)
                                Icons.Filled.Visibility
                            else Icons.Filled.VisibilityOff


                            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                                Icon(imageVector = image, tint = Color.White, contentDescription = "showHidePass")
                            }
                        },

                        value = password,
                        onValueChange = {
                            password = it
                        }
                    )
                }

                // Enter button part \\

                Column(modifier = Modifier
                    .padding(80.dp)
                    .width(1400.dp)
                    .height(435.dp)
                    .fillMaxWidth()
                    .wrapContentSize(Alignment.BottomCenter)) {
                    Button(modifier = Modifier.height(120.dp).width(230.dp)
                        .padding(30.dp),
                        onClick = { startActivity(intent) },
                        border = BorderStroke(1.dp, Color.White),
                        shape = RoundedCornerShape(30), // = 30% percent
                        colors = ButtonDefaults.outlinedButtonColors(backgroundColor = Color.Transparent, contentColor = Color.Transparent),
                    ){
                        Text(
                            text = "Войти",
                            textAlign = TextAlign.Center,
                            color = Color.White,
                            fontSize = 24.sp,
                            fontFamily = montserrat_bold
                        )
                        Icon(
                            imageVector = FeatherIcons.LogIn,
                            contentDescription = "enterIcon",
                            modifier = Modifier.padding(top = 4.dp, start = 5.dp),
                            tint = Color(0xFFFFFFFF)
                        )
                    }
                }

                // Forget password part \\

                Column(modifier = Modifier
                    .padding(30.dp)
                    .width(1500.dp)
                    .height(550.dp)
                    .fillMaxWidth()
                    .wrapContentSize(Alignment.BottomCenter)) {
                    ClickableText(
                        modifier = Modifier,
                        text = annotatedLinkStringPassword,
                        onClick = {
                            annotatedLinkStringPassword
                                .getStringAnnotations("URL_Pass", it, it)
                                .firstOrNull()?.let { stringAnnotation ->
                                    uriHandler.openUri(stringAnnotation.item)
                                }
                        }
                    )
                }

                // Registration part \\

                Column(modifier = Modifier
                    .padding(30.dp)
                    .width(1500.dp)
                    .height(590.dp)
                    .wrapContentSize(Alignment.BottomCenter)) {
                    ClickableText(
                        modifier = Modifier,
                        text = annotatedLinkStringReg,
                        onClick = {
                            annotatedLinkStringReg
                                .getStringAnnotations("URL_Reg", it, it)
                                .firstOrNull()?.let { stringAnnotation ->
                                    uriHandler.openUri(stringAnnotation.item)
                                }
                        }
                    )
                }

                // logo_part \\

                Column(modifier = Modifier
                    .padding(40.dp)
                    .width(80.dp)
                    .height(690.dp)
                    .fillMaxWidth()
                    .wrapContentSize(Alignment.BottomCenter)) {
                    Button(modifier = Modifier,
                        onClick = { context.startActivity(intentVk) },
                        elevation = ButtonDefaults.elevation(
                            defaultElevation = 0.dp,
                            pressedElevation = 0.dp,
                            disabledElevation = 0.dp
                        ),
                        colors = buttonColors(backgroundColor = blue69, contentColor = blue69)
                    ) {
                        Image(
                            painterResource(R.drawable.vk_logo),
                            contentDescription = "vk_logo",
                            modifier = Modifier.requiredSize(50.dp)
                        )
                    }
                }
                Column(modifier = Modifier
                    .padding(40.dp)
                    .width(280.dp)
                    .height(690.dp)
                    .fillMaxWidth()
                    .wrapContentSize(Alignment.BottomEnd)) {
                    Button(modifier = Modifier,
                        onClick = { context.startActivity(intentTg) },
                        elevation = ButtonDefaults.elevation(
                            defaultElevation = 0.dp,
                            pressedElevation = 0.dp,
                            disabledElevation = 0.dp
                        ),
                        colors = buttonColors(backgroundColor = blue69, contentColor = blue69)
                    ) {
                        Image(
                            painterResource(R.drawable.telegram_logo),
                            contentDescription = "telegram_logo",
                            modifier = Modifier.requiredSize(50.dp)
                        )
                    }
                }
            }
        }
    }
}