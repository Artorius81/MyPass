package com.vvsu.mypass

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.OvershootInterpolator
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vvsu.mypass.ui.theme.MyPassTheme
import com.vvsu.mypass.ui.theme.blue69


@SuppressLint("CustomSplashScreen")
class SplashActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyPassTheme {
                val paddingModifier = Modifier.padding(10.dp)
                val widthOnTopBar = "                                                         "
                val montserrat_bold = FontFamily(Font(R.font.montserrat_medium))
                val montserrat_italic = FontFamily(Font(R.font.montserrat_lightitalic))

                val scale = remember {
                    Animatable(0f)
                }

                LaunchedEffect(key1 = true) {
                    scale.animateTo(
                        targetValue = 1f,
                        animationSpec = tween(
                            durationMillis = 300,
                            easing = {
                                OvershootInterpolator(0.7f).getInterpolation(it)
                            })
                    )
                }

                Box(modifier = Modifier
                    .fillMaxSize()
                    .background(blue69),
                )
                Column(modifier = Modifier
                    .padding(30.dp)
                    .scale(scale.value)
                    .width(1500.dp)
                    .height(270.dp)
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
                        .height(605.dp)
                        .fillMaxSize()
                        .scale(scale.value)
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
                    .padding(15.dp)
                    .width(1500.dp)
                    .scale(scale.value)
                    .height(600.dp)
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
                Handler(Looper.getMainLooper()).postDelayed({
                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                    finish()
                }, 1500)
            }
        }
    }
}