package com.imc

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.imc.MainActivity.Companion.IMC_KEY

class ResultActivity : AppCompatActivity() {

    /* OBJECTS */
    private lateinit var emoji: ImageView
    private lateinit var statusResult: TextView
    private lateinit var numberResult: TextView
    private lateinit var descriptionResult: TextView
    private lateinit var recalcButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)

        // Imc result from Main Activity
        val imcResult = intent.extras?.getDouble(IMC_KEY) ?: -1.0
        findObjects()
        imcResult(imcResult)
        recalculate()
    }

    // Find objects
    private fun findObjects() {
        emoji = findViewById(R.id.emoji)
        statusResult = findViewById(R.id.status_result)
        numberResult = findViewById(R.id.number_result)
        descriptionResult = findViewById(R.id.description_result)
        recalcButton = findViewById(R.id.recal_button)
    }

    // Change values depending the imc result:
    private fun imcResult(result: Double) {
        numberResult.text = result.toString()
        when (result) {
            in 0.0..18.5 -> {
                val underWeightEmoji = ContextCompat.getDrawable(this, R.drawable.ic_underweight)
                val underweightColor = ContextCompat.getColor(this, R.color.underweight_col)
                emoji.setImageDrawable(underWeightEmoji)
                statusResult.setTextColor(underweightColor)
                statusResult.text = getString(R.string.underweight)
                descriptionResult.text = getString(R.string.underweight_des)
            }

            in 18.6..24.9 -> {
                val normalEmoji = ContextCompat.getDrawable(this, R.drawable.ic_normal)
                val normalColor = ContextCompat.getColor(this, R.color.normal_col)
                emoji.setImageDrawable(normalEmoji)
                statusResult.setTextColor(normalColor)
                statusResult.text = getString(R.string.normal_weight)
                descriptionResult.text = getString(R.string.normal_des)
            }

            in 25.0..29.9 -> {
                val overWeightEmoji = ContextCompat.getDrawable(this, R.drawable.ic_overweight)
                val overweightColor = ContextCompat.getColor(this, R.color.overweight_col)
                emoji.setImageDrawable(overWeightEmoji)
                statusResult.setTextColor(overweightColor)
                statusResult.text = getString(R.string.overweight)
                descriptionResult.text = getString(R.string.overeight_des)
            }

            in 30.0..99.9 -> {
                val obeseEmoji = ContextCompat.getDrawable(this, R.drawable.ic_obese)
                val obeseColor = ContextCompat.getColor(this, R.color.obese_col)
                emoji.setImageDrawable(obeseEmoji)
                statusResult.setTextColor(obeseColor)
                statusResult.text = getString(R.string.obese)
                descriptionResult.text = getString(R.string.obese_des)
            }

            else -> {
                val errorEmoji = ContextCompat.getDrawable(this, R.drawable.ic_error)
                emoji.setImageDrawable(errorEmoji)
                statusResult.text = getString(R.string.error)
                descriptionResult.text = getString(R.string.error_des)
            }
        }
    }

    // Return to MainActivity
    private fun recalculate() {
        recalcButton.setOnClickListener {
            onBackPressed()
        }
    }
}