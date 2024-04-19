package com.imc

import android.content.Context
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider

class MainActivity : AppCompatActivity() {

    /* INITIAL VALUES */
    private var isMaleSelected: Boolean = false
    private var isFemaleSelected: Boolean = false

    /* OBJECTS: */
    // Male and female cards:
    private lateinit var maleCard: CardView
    private lateinit var femaleCard: CardView

    //Height:
    private lateinit var heightValue: TextView
    private lateinit var rangeSlider: RangeSlider

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

    // Instruction texts:
    private lateinit var instructionTxt: TextView

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

        heightValue = findViewById(R.id.height_value)
        rangeSlider = findViewById(R.id.range_slider)

        weightMinus = findViewById(R.id.weight_minus)
        weightPlus = findViewById(R.id.weight_plus)

        ageMinus = findViewById(R.id.age_minus)
        agePlus = findViewById(R.id.age_plus)

        calculateBtn = findViewById(R.id.calculate_btn)

        instructionTxt = findViewById(R.id.welcome_txt)
    }

    // Listeners
    private fun listeners() {
        maleCard.setOnClickListener {
            maleStatus()
            setCardColor()
            changeInstructions(isMaleSelected)
        }
        femaleCard.setOnClickListener {
            femaleStatus()
            setCardColor()
            changeInstructions(isFemaleSelected)
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

    // Change instructions
    fun changeInstructions(isSelected: Boolean) {
        when {
            isSelected -> instructionTxt.text =
                ContextCompat.getString(this, R.string.select_height)
        }
    }

}