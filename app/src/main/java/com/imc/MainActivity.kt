package com.imc

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.cardview.widget.CardView
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
    private lateinit var welcomeTxt: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        findComponent()
        listeners()
    }

    // Function to find components:
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

        welcomeTxt = findViewById(R.id.welcome_txt)
    }

    private fun listeners() {
        maleCard.setOnClickListener {

        }
        femaleCard.setOnClickListener {

        }
    }

}