package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Найти контейнер для фрагмента
        val container = findViewById<FrameLayout>(R.id.frame_layout)

        // Создать экземпляр фрагмента
        val fragment = BlankFragment()

        // Замените текущий фрагмент на новый фрагмент
        supportFragmentManager.beginTransaction().replace(container.id, fragment).commit()
    }
}