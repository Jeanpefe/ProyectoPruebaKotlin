package com.jesus.androidkotlin.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.jesus.androidkotlin.R

class TodoActivity : AppCompatActivity() {

    private lateinit var rvCategories: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo)
        initComponent()
    }

    private fun initComponent() {
        rvCategories = findViewById(R.id.rvCategories)
    }
}