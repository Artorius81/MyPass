package com.vvsu.mypass


import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vvsu.mypass.ui.theme.MyPassTheme
import com.vvsu.mypass.ui.theme.blue69
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import com.vvsu.mypass.ui.theme.WhiteCard
import com.vvsu.mypass.ui.theme.WhiteMain


class MainActivity : ComponentActivity() {

    var backPressedTime: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyPassTheme() {
                val montserrat_bold = FontFamily(Font(R.font.montserrat_medium))

                Box(modifier = Modifier
                    .fillMaxSize()
                    .background(WhiteCard),
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
        }
    }
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