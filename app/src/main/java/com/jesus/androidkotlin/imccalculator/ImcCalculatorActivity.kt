package com.jesus.androidkotlin.imccalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider
import com.jesus.androidkotlin.R
import org.w3c.dom.Text
import java.text.DecimalFormat

class ImcCalculatorActivity : AppCompatActivity() {

    private var isMaleSelected:Boolean = true
    private var isFemaleSelected:Boolean = false
    private var currentWeight:Int = 70
    private var currentAge:Int = 30
    private var currentHeight:Int = 120
    private lateinit var viewMale:CardView // El lateinit es para que se inicie cuando se lo pidamos
    private lateinit var viewFemale:CardView
    private lateinit var tvHeight:TextView
    private lateinit var rsHeight: RangeSlider
    private lateinit var tvWeight: TextView
    private lateinit var btnSubtractWeight: FloatingActionButton
    private lateinit var btnPlusWeight: FloatingActionButton
    private lateinit var tvAge: TextView
    private lateinit var btnSubtractAge: FloatingActionButton
    private lateinit var btnPlusAge: FloatingActionButton
    private lateinit var btnCalculate: Button

    companion object {

    }
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
        tvWeight = findViewById(R.id.tvWeight)
        btnSubtractWeight = findViewById(R.id.btnSubtractWeight)
        btnPlusWeight = findViewById(R.id.btnPlusWeight)
        tvAge = findViewById(R.id.tvAge)
        btnSubtractAge = findViewById(R.id.btnSubtractAge)
        btnPlusAge = findViewById(R.id.btnPlusAge)
        btnCalculate = findViewById(R.id.btnCalculate)
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
            currentHeight = DecimalFormat("#.##").format(value).toInt()
            tvHeight.text = currentHeight.toString() + "cm"
        }

        btnPlusWeight.setOnClickListener{
            currentWeight += 1
            tvWeight.text = currentWeight.toString()
        }

        btnSubtractWeight.setOnClickListener{
            currentWeight -= 1
            tvWeight.text = currentWeight.toString()
        }

        btnPlusAge.setOnClickListener{
            currentAge += 1
            tvAge.text = currentAge.toString()
        }

        btnSubtractAge.setOnClickListener{
            currentAge -= 1
            tvAge.text = currentAge.toString()
        }

        btnCalculate.setOnClickListener{
            val imc = calculateIMC()
            intent = Intent(this, ResultImcActivity::class.java)
            intent.putExtra("IMC_RESULT", imc)
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

    private fun setWeight() {
        tvWeight.text = currentWeight.toString()
    }

    private fun setAge() {
        tvAge.text = currentAge.toString()
    }
    private fun initUI() {
        setGenderColor()
        setWeight()
        setAge()
    }

    private fun calculateIMC():Double {
        val df = DecimalFormat("#.##")
        return df.format(currentWeight / (currentHeight.toDouble()/100 * currentHeight.toDouble()/100)).toDouble()
    }
}