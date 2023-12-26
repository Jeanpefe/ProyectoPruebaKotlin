package com.jesus.androidkotlin.imccalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.jesus.androidkotlin.R

class ResultImcActivity : AppCompatActivity() {

    private lateinit var btnReturnCalculator: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_imc)

        val result = intent.extras?.getDouble("IMC_RESULT") ?: -1.0
        initComponents()
        initListeners()
    }

    private fun initComponents() {
        btnReturnCalculator = findViewById(R.id.btnReturnCalculator)
    }
    private fun initListeners() {
        btnReturnCalculator.setOnClickListener{
            intent = Intent(this, ImcCalculatorActivity::class.java)
            startActivity(intent)
        }
    }
    private fun returnToCalculator() {
        var hola = 3
    }
}