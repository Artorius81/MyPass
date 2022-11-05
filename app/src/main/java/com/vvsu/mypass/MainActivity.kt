package com.vvsu.mypass


import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.vvsu.mypass.ui.theme.MyPassTheme
import com.vvsu.mypass.ui.theme.WhiteCard
import com.vvsu.mypass.ui.theme.blue69


@Suppress("DEPRECATION")
class MainActivity : ComponentActivity() {

    private var backPressedTime: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyPassTheme {
                val intent = Intent(this, LoginActivity::class.java)
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
                            color = blue69,
                            fontSize = 45.sp,
                            fontFamily = montserrat_bold
                        )
                    )
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
                        onClick = {
                            Firebase.auth.signOut()
                            startActivity(intent)
                        },
                        border = BorderStroke(1.dp, Color.White),
                        shape = RoundedCornerShape(30), // = 30% percent
                        colors = ButtonDefaults.outlinedButtonColors(
                            backgroundColor = Color.Transparent,
                            contentColor = Color.Transparent
                        ),
                    ) {
                        Text(
                            text = "Выйти",
                            textAlign = TextAlign.Center,
                            color = blue69,
                            fontSize = 24.sp,
                            fontFamily = montserrat_bold
                        )
                    }
                }
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
}