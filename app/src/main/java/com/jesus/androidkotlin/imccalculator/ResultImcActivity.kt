package com.jesus.androidkotlin.imccalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.jesus.androidkotlin.R

class ResultImcActivity : AppCompatActivity() {

    private lateinit var btnReturnCalculator: Button
    private lateinit var tvImc: TextView
    private lateinit var tvImcDesc: TextView
    private lateinit var tvImcFullDesc: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_imc)

        val result = intent.extras?.getDouble("IMC_RESULT") ?: -1.0
        initComponents()
        initListeners()
        initUI(result)
    }

    private fun initComponents() {
        btnReturnCalculator = findViewById(R.id.btnReturnCalculator)
        tvImc = findViewById(R.id.tvImc)
        tvImcDesc = findViewById(R.id.tvImcDesc)
        tvImcFullDesc = findViewById(R.id.tvImcFullDesc)
    }
    private fun initListeners() {
        btnReturnCalculator.setOnClickListener{
            intent = Intent(this, ImcCalculatorActivity::class.java)
            startActivity(intent)
        }
    }

    private fun initUI(result: Double) {
        tvImc.text = result.toString()
        when {
            (result < 16) -> {
                tvImcDesc.text = "Primer rango"
                tvImcFullDesc.text = "Primer rango más largo"
            }
            (result in 16.0..16.99) -> {
                tvImcDesc.text = "Segundo rango"
                tvImcFullDesc.text = "Segundo rango más largo"
            }
            (result in 17.0..18.49) -> {
                tvImcDesc.text = "Tercer rango"
                tvImcFullDesc.text = "Tercer rango más largo"
            }
            (result in 18.5..24.99) -> {
                tvImcDesc.text = "Cuarto rango"
                tvImcFullDesc.text = "Cuarto rango más largo"
            }
            (result in 25.0..34.99) -> {
                tvImcDesc.text = "Quinto rango"
                tvImcFullDesc.text = "Quinto rango más largo"
            }
            (result in 35.0..40.0) -> {
                tvImcDesc.text = "Sexto rango"
                tvImcFullDesc.text = "Sexto rango más largo"
            }
            (result in 40.0..49.99) -> {
                tvImcDesc.text = "Séptimo rango"
                tvImcFullDesc.text = "Séptimo rango más largo"
            } else -> {

            }
        }
    }
}