package com.example.mypass

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity

    @Suppress("DEPRECATION")

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        // SplashScreen в полный экран
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        // Метод для задержки сплэша
        Handler().postDelayed({
            val intent = Intent(this, LoginForm::class.java)
            startActivity(intent)
            finish()
        }, 3000) // 3000 в миллисекундах
    }
}