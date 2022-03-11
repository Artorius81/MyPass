package com.example.mypass

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.PopupMenu
import android.widget.Toolbar
import androidx.navigation.ActivityNavigator
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.mypass.databinding.ActivityMainPageBinding

class MainPage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_page)
    }
}