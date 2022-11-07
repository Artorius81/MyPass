package com.vvsu.mypass


import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.ActivityCompat
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.vvsu.mypass.ui.theme.MyPassTheme
import com.vvsu.mypass.ui.theme.black


@Suppress("DEPRECATION")
class MainActivity : ComponentActivity() {

    private var backPressedTime: Long = 0
    private val montserrat_bold = FontFamily(Font(R.font.montserrat_medium))

    override fun onCreate(savedInstanceState: Bundle?) {
        requestPermission()
        super.onCreate(savedInstanceState)
        setContent {
            MyPassTheme {

                val intent = Intent(this, LoginActivity::class.java)

                Box(modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White),
                )
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
                            backgroundColor = Color.White,
                        ),
                    ) {
                        Text(
                            text = "Начать",
                            textAlign = TextAlign.Center,
                            color = black,
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

    private fun hasPermission() : Boolean {
        // It is true when we have a permission
        return ActivityCompat.checkSelfPermission(this, android.Manifest.permission.READ_CALENDAR) == PackageManager.PERMISSION_GRANTED
    }

    // Request permission
    private fun requestPermission() {
        val permission = mutableListOf<String>()

        if (!hasPermission()) {
            permission.add(android.Manifest.permission.READ_CALENDAR)
        }
        if (permission.isNotEmpty()) {
            ActivityCompat.requestPermissions(this, permission.toTypedArray(), 0)
        }
    }

    @Deprecated("Deprecated in Java", ReplaceWith(
        "super.onRequestPermissionsResult(requestCode, permissions, grantResults)",
        "androidx.activity.ComponentActivity"
    )
    )
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 0 && grantResults.isNotEmpty()) {
            for (i in grantResults.indices) {
                if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                    Log.d("PermissionsRequested", "${permissions[i]} granted" )
                }
            }
        }
    }
}