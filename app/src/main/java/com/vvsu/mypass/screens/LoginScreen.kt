@file:Suppress("UNUSED_EXPRESSION")

package com.vvsu.mypass.screens

import android.os.Build
import android.view.KeyEvent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.talhafaki.composablesweettoast.util.SweetToastUtil.SweetError
import com.vvsu.mypass.R
import com.vvsu.mypass.ui.theme.WhiteCard
import com.vvsu.mypass.ui.theme.black
import com.vvsu.mypass.ui.theme.blue69
import compose.icons.FeatherIcons
import compose.icons.feathericons.Key
import compose.icons.feathericons.LogIn
import compose.icons.feathericons.User


@OptIn(ExperimentalComposeUiApi::class)
@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun LoginScreen() {

    val montserrat_light = FontFamily(Font(R.font.montserrat_light))
    val montserrat_italic = FontFamily(Font(R.font.montserrat_lightitalic))
    val montserrat_bold = FontFamily(Font(R.font.montserrat_medium))
    val (focusRequester) = FocusRequester.createRefs()
    var password by remember { mutableStateOf(("")) }
    var loginError by remember { mutableStateOf(false) }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }
    var email by remember { mutableStateOf(("")) }
    val keyboardController = LocalSoftwareKeyboardController.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(blue69),
    )
    Column(
        modifier = Modifier
            .padding(top = 50.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.padding(bottom = 5.dp),
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
        Box(
            modifier = Modifier
                .width(250.dp)
                .padding(bottom = 5.dp)
                .height(1.dp)
                .background(WhiteCard)
        ) {
            Divider()
        }
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
        OutlinedTextField(
            modifier = Modifier.padding(top = 80.dp).onKeyEvent { if (it.nativeKeyEvent.keyCode == KeyEvent.KEYCODE_ENTER) {
                focusRequester.requestFocus()
                true }
                false
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor = Color.Black,
                backgroundColor = Color.Transparent,
                cursorColor = Color.White,
                focusedBorderColor = Color.White,
                unfocusedBorderColor = Color.White
            ),
            textStyle = TextStyle(fontSize = 20.sp, color = Color.White),
            shape = RoundedCornerShape(25.dp),
            singleLine = true,
            label = {
                Text(
                    text = "Логин",
                    fontFamily = montserrat_bold,
                    color = Color.White,
                    fontSize = 17.sp
                )
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onDone = { focusRequester.requestFocus() }),
            leadingIcon = {
                Icon(
                    imageVector = FeatherIcons.User,
                    tint = Color.White,
                    contentDescription = "userIcon"
                )
            },
            value = email,
            onValueChange = {
                email = it
            }
        )
        OutlinedTextField(
            modifier = Modifier.padding(top = 10.dp).focusRequester(focusRequester),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor = Color.Black,
                backgroundColor = Color.Transparent,
                cursorColor = Color.White,
                focusedBorderColor = Color.White,
                unfocusedBorderColor = Color.White
            ),
            textStyle = TextStyle(fontSize = 20.sp, color = Color.White),
            shape = RoundedCornerShape(25.dp),
            singleLine = true,
            label = {
                Text(
                    text = "Пароль",
                    fontFamily = montserrat_bold,
                    color = Color.White,
                    fontSize = 17.sp
                )
            },
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = { keyboardController?.hide() }),
            leadingIcon = {
                Icon(
                    imageVector = FeatherIcons.Key,
                    tint = Color.White,
                    contentDescription = "passwordIcon"
                )
            },
            trailingIcon = {
                val image = if (passwordVisible)
                    Icons.Filled.Visibility
                else Icons.Filled.VisibilityOff


                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(
                        imageVector = image,
                        tint = Color.White,
                        contentDescription = "showHidePass"
                    )
                }
            },
            value = password,
            onValueChange = {
                password = it
            }
        )
        Button(
            modifier = Modifier
                .height(90.dp)
                .padding(top = 30.dp),
            onClick = { if (email.isEmpty() || password.isEmpty()) loginError = true },
            border = BorderStroke(1.dp, Color.White),
            shape = RoundedCornerShape(25), // = 30% percent
            colors = ButtonDefaults.outlinedButtonColors(
                backgroundColor = Color.White,
            ),
        ) {
            Text(
                text = "Войти",
                textAlign = TextAlign.Center,
                color = black,
                fontSize = 24.sp,
                fontFamily = montserrat_bold
            )
            Icon(
                imageVector = FeatherIcons.LogIn,
                contentDescription = "enterIcon",
                modifier = Modifier.padding(top = 4.dp, start = 5.dp),
                tint = black
            )
        }
    }
    if (loginError) {
        loginError = false
        SweetError(message = "Все поля должны быть заполнены", duration = 2, contentAlignment = Alignment.BottomCenter, padding = PaddingValues(bottom = 100.dp))
    }
}