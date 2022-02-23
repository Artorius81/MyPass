package com.example.mypass

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

    @SuppressLint("StaticFieldLeak")
    private var register_text: TextView? = null //объявление переменной регистрации
    @SuppressLint("StaticFieldLeak")
    private var fpassword: TextView? = null //объявление переменной забыли пароль
    @SuppressLint("StaticFieldLeak")
    private var instagram: Button? = null //объявление переменной инстаграма
    @SuppressLint("StaticFieldLeak")
    private var vk: Button? = null //объявление переменной вк
    @SuppressLint("StaticFieldLeak")
    private var telegram: Button? = null //объявление переменной телеграма

class LoginForm : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_form)

        //гиперссылка на регистрацию
        register_text = findViewById(R.id.register_text)
        with(register_text) {
            this?.setMovementMethod(LinkMovementMethod.getInstance())

        }

        //гиперссылка на забыли пароль
        fpassword = findViewById(R.id.fpassword)
        with(fpassword) {
            this?.setMovementMethod(LinkMovementMethod.getInstance())

        }

        //гиперссылка на инстаграм
        instagram = findViewById(R.id.instagram)
        instagram?.setOnClickListener {
            val instagram_link = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/vvsu.ru/"))
            startActivity(instagram_link)
        }

        //гиперссылка на вк
        vk = findViewById(R.id.vk)
        vk?.setOnClickListener {
            val vk_link = Intent(Intent.ACTION_VIEW, Uri.parse("https://vk.com/vgues"))
            startActivity(vk_link)
        }

        //гиперссылка на телегу
        telegram = findViewById(R.id.telegram)
        telegram?.setOnClickListener {
            val telegram_link = Intent(Intent.ACTION_VIEW, Uri.parse("https://t.me/vvsuru"))
            startActivity(telegram_link)
        }

    }
}