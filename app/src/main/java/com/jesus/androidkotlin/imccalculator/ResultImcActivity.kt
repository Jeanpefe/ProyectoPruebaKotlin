package com.jesus.androidkotlin.imccalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jesus.androidkotlin.R

class ResultImcActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_imc)

        val result = intent.extras?.getDouble("IMC_RESULT") ?: -1.0
    }
}