package com.example.academynotesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Навигация между фрагментами, но кнопки не работают
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.navFragment) as NavHostFragment
        val navController = navHostFragment.navController
        setupActionBarWithNavController(navController)

    }
}