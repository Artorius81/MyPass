package com.vvsu.mypass

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
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
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.vvsu.mypass.ui.theme.MyPassTheme
import com.vvsu.mypass.ui.theme.blue69
import com.vvsu.mypass.utils.initFirebase


class WelcomeActivity : ComponentActivity() {


    private val rootRef = FirebaseDatabase.getInstance().reference
    private val uid = FirebaseAuth.getInstance().currentUser!!.uid
    private val uidRef = rootRef.child("users").child(uid)
    private val paddingModifier = Modifier.padding(10.dp)
    private val widthOnTopBar = "                                                         "
    private val montserrat_italic = FontFamily(Font(R.font.montserrat_lightitalic))
    private val montserrat_bold = FontFamily(Font(R.font.montserrat_medium))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyPassTheme {
                initFirebase()
                WelcomeScreen()

                uidRef.get().addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val snapshot = task.result
                        val username = snapshot?.child("name")?.getValue(String::class.java)
                        Toast.makeText(baseContext, "$username",
                            Toast.LENGTH_SHORT).show()
                    }
                }

                Handler(Looper.getMainLooper()).postDelayed({
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }, 2000)
            }
        }
    }

    @Composable
    private fun WelcomeScreen() {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(blue69),
        )
        Column(
            modifier = Modifier
                .height(605.dp)
                .fillMaxSize()
                .padding(5.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                shape = RoundedCornerShape(20.dp),
                elevation = 10.dp,
                modifier = paddingModifier
                    .height(2.dp)
            ) {
                Text(text = widthOnTopBar, modifier = paddingModifier)
            }
        }
        Column(
            modifier = Modifier
                .padding(30.dp)
                .width(1500.dp)
                .height(270.dp)
                .fillMaxWidth()
                .wrapContentSize(Alignment.BottomCenter)
        ) {
            Text(
                modifier = Modifier,
                text = "&username",
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
                .padding(15.dp)
                .width(1500.dp)
                .height(600.dp)
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center)
        ) {
            Text(
                modifier = Modifier,
                text = "Добро пожаловать в MyPass",
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
}
