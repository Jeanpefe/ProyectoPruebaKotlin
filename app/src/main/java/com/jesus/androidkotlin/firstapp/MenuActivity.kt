package com.jesus.androidkotlin.firstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.jesus.androidkotlin.R
import com.jesus.androidkotlin.imccalculator.ImcCalculatorActivity
import com.jesus.androidkotlin.todoapp.TodoActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        val btnSaludApp = findViewById<Button>(R.id.btnSaludApp)
        val btnImcApp = findViewById<Button>(R.id.btnIMCApp)
        val btnTodoApp = findViewById<Button>(R.id.btnTodoApp)
        btnSaludApp.setOnClickListener {navigateToSaludApp()}
        btnImcApp.setOnClickListener {navigateToImcApp()}
        btnTodoApp.setOnClickListener {navigateToTodoApp()}
    }

    private fun navigateToSaludApp(){
        val intent = Intent(this, FirstAppActivity::class.java)
        startActivity(intent)
    }
    private fun navigateToImcApp(){
        val intent = Intent(this, ImcCalculatorActivity::class.java)
        startActivity(intent)
    }
    private fun navigateToTodoApp(){
        val intent = Intent(this, TodoActivity::class.java)
        startActivity(intent)
    }
}