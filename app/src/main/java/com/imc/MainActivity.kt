package com.imc

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    /* INITIAL VALUES */
    private var isMaleSelected: Boolean = false
    private var isFemaleSelected: Boolean = false

    // Current height
    private var currentHeight: Int = 120

    // Current weight
    private var currentWeight: Int = 60

    // Current age
    private var currentAge: Int = 30


    /* OBJECTS: */

    // Male and female cards:
    private lateinit var maleCard: CardView
    private lateinit var femaleCard: CardView

    //Height:
    private lateinit var rangeSlider: RangeSlider
    private lateinit var heightValue: TextView

    //Weight:
    private lateinit var weightValue: TextView
    private lateinit var weightMinus: FloatingActionButton
    private lateinit var weightPlus: FloatingActionButton

    // Age:
    private lateinit var ageValue: TextView
    private lateinit var ageMinus: FloatingActionButton
    private lateinit var agePlus: FloatingActionButton

    // Calculate button:
    private lateinit var calculateBtn: AppCompatButton

    companion object {
        const val IMC_KEY = "IMC_RESULT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        findComponent()
        listeners()
    }

    // Find components
    private fun findComponent() {
        maleCard = findViewById(R.id.male_card)
        femaleCard = findViewById(R.id.female_card)

        rangeSlider = findViewById(R.id.range_slider)
        heightValue = findViewById(R.id.height_value)

        weightMinus = findViewById(R.id.weight_minus)
        weightPlus = findViewById(R.id.weight_plus)
        weightValue = findViewById(R.id.weight_value)

        ageMinus = findViewById(R.id.age_minus)
        agePlus = findViewById(R.id.age_plus)
        ageValue = findViewById(R.id.age_value)

        calculateBtn = findViewById(R.id.calculate_btn)
    }

    // Listeners
    private fun listeners() {
        maleCard.setOnClickListener {
            maleStatus()
            setCardColor()
        }
        femaleCard.setOnClickListener {
            femaleStatus()
            setCardColor()
        }
        rangeSlider.addOnChangeListener { _, value, _ ->
            currentHeight = value.toInt()
            val format = DecimalFormat("###")
            val formated = format.format(value)
            heightValue.text = "$formated CM"
        }
        weightMinus.setOnClickListener {
            minusWeight()
        }
        weightPlus.setOnClickListener {
            plusWeight()
        }
        ageMinus.setOnClickListener {
            minusAge()
        }
        agePlus.setOnClickListener {
            plusAge()
        }
        calculateBtn.setOnClickListener {
            val imc = imcResult()
            navToResult(imc)
        }
    }

    // Get and return color
    private fun getColor(isSelected: Boolean): Int {
        return if (isSelected) {
            ContextCompat.getColor(this, R.color.component_selected)
        } else ContextCompat.getColor(this, R.color.component)
    }

    // Set card color.
    private fun setCardColor() {
        maleCard.setCardBackgroundColor(getColor(isMaleSelected))
        femaleCard.setCardBackgroundColor(getColor(isFemaleSelected))
    }

    // Change male card status.
    private fun maleStatus() {
        isMaleSelected = true
        isFemaleSelected = false
    }

    // Change female card status.
    private fun femaleStatus() {
        isFemaleSelected = true
        isMaleSelected = false
    }

    // Minus weight button logic.
    private fun minusWeight() {
        currentWeight--
        weightValue.text = currentWeight.toString()
    }

    // Plus weight button logic.
    private fun plusWeight() {
        currentWeight++
        weightValue.text = currentWeight.toString()
    }

    // Minus age button logic.
    private fun minusAge() {
        currentAge--
        ageValue.text = currentAge.toString()
    }

    // Plus age button logic.
    private fun plusAge() {
        currentAge++
        ageValue.text = currentAge.toString()
    }

    // Calculate the IMC
    private fun imcResult(): Double {
        val df = DecimalFormat("#.##")
        return df.format(currentWeight / ((currentHeight * 0.01) * (currentHeight * 0.01)))
            .toDouble()
    }

    // Calculate button intent
    private fun navToResult(result: Double) {
        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra(IMC_KEY, result)
        startActivity(intent)
    }
}