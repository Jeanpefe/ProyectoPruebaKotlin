package com.jesus.androidkotlin.imccalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.google.android.material.slider.RangeSlider
import com.jesus.androidkotlin.R
import java.text.DecimalFormat

class ImcCalculatorActivity : AppCompatActivity() {

    private var isMaleSelected:Boolean = true
    private var isFemaleSelected:Boolean = false

    private lateinit var viewMale:CardView // El lateinit es para que se inicie cuando se lo pidamos
    private lateinit var viewFemale:CardView // El lateinit es para que se inicie cuando se lo pidamos
    private lateinit var tvHeight:TextView
    private lateinit var rsHeight: RangeSlider

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc_calculator)
        initComponents()
        initListeners()
        initUI()
    }

    private fun initComponents(){
        viewMale = findViewById(R.id.viewMale)
        viewFemale = findViewById(R.id.viewFemale)
        tvHeight = findViewById(R.id.tvHeight)
        rsHeight = findViewById(R.id.rsHeight)
    }

    private fun initListeners() {
        viewMale.setOnClickListener{
            if (!isMaleSelected) {
                changeGender()
                setGenderColor()}
            }
        viewFemale.setOnClickListener{
            if (!isFemaleSelected) {
                changeGender()
                setGenderColor()}
            }
        rsHeight.addOnChangeListener{_, value, _ ->
            tvHeight.text = DecimalFormat("#.##").format(value) + "cm"
        }
    }

    private fun changeGender() {
        isMaleSelected = !isMaleSelected
        isFemaleSelected = !isFemaleSelected
    }
    private fun setGenderColor() {
        viewMale.setCardBackgroundColor(getBackgroundColor(isMaleSelected))
        viewFemale.setCardBackgroundColor(getBackgroundColor(isFemaleSelected))
    }

    private fun getBackgroundColor(isSelectedComponent:Boolean): Int {

        val colorReference = if(isSelectedComponent) {
            R.color.background_component_selected
        } else {
            R.color.background_component
        }
        return ContextCompat.getColor(this, colorReference)
    }

    private fun initUI() {
        setGenderColor()
    }
}