package com.vvsu.mypass

import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.text.input.*
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.vvsu.mypass.screens.LoginScreen
import com.vvsu.mypass.ui.theme.MyPassTheme
import com.vvsu.mypass.view.ViewModel


@Suppress("DEPRECATION")
class LoginActivity : ComponentActivity() {

    private lateinit var auth: FirebaseAuth
    private var backPressedTime: Long = 0
    private val viewModel: ViewModel by viewModels()

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        auth = Firebase.auth
        super.onCreate(savedInstanceState)
        installSplashScreen().apply {
            setKeepVisibleCondition{
                viewModel.isLoading.value
            }
        }
        setContent {
            MyPassTheme {
                LoginScreen()
            }
        }
    }

//    private fun signIn(email: String, password: String) {
//        if (email.isEmpty() || password.isEmpty()) {
//            Toast.makeText(this, "Все поля должны быть заполнены", Toast.LENGTH_SHORT).show()
//            return
//        }
//        if (!isConnectedToNetwork()) {
//            Toast.makeText(this, "Нет подключения к сети Интернет", Toast.LENGTH_SHORT).show()
//            return
//        }
//        // [START sign_in_with_email]
//        auth.signInWithEmailAndPassword(email, password)
//            .addOnCompleteListener(this) { task ->
//                if (task.isSuccessful) {
//                    // Sign in success, update UI with the signed-in user's information
//                    val intent = Intent(this, WelcomeActivity::class.java)
//                    startActivity(intent)
//                    updateUI()
//                } else {
//                    // If sign in fails, display a message to the user.
//                    Toast.makeText(baseContext, "Неверный логин или пароль",
//                        Toast.LENGTH_SHORT).show()
//                    updateUI()
//                }
//                if (!isConnectedToNetwork()) {
//                    Toast.makeText(this, "Нет подключения к сети Интернет", Toast.LENGTH_SHORT).show()
//                }
//            }
//        // [END sign_in_with_email]
//    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        if (backPressedTime + 3000 > System.currentTimeMillis()) {
            super.onBackPressed()
            finishAffinity()
        } else {
            Toast.makeText(this, "Нажмите второй раз для выхода из приложения", Toast.LENGTH_LONG)
                .show()
        }
        backPressedTime = System.currentTimeMillis()
    }
}