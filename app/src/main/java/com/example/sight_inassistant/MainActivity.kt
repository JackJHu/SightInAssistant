package com.example.sight_inassistant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sight_inassistant.databinding.ActivityMainBinding





class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.calculateClicksButton.setOnClickListener{calculateClicks()}
    }

    private fun calculateClicks(){
        val yardsString = binding.yardsInputEdits.text.toString()
        val yards = yardsString.toDoubleOrNull()
        val inchesString = binding.distanceFromBulleyeInput.text.toString()
        val inches = inchesString.toDoubleOrNull()

        if ( yards == null) {
            return
        }

        if (inches == null){
            return
        }

        val clicksNumerator = inches * 100

        val MOA = when (binding.MOAGroup.checkedRadioButtonId){
            R.id.MOA_Buton_Two -> 2.000
            R.id.MOA_Button_One -> 1.000
            R.id.MOA_Button_Half -> 0.500
            R.id.MOA_Button_OneFourth -> 0.250
            else -> 0.125
        }

        var clicksDenominator = yards * MOA

        var clicks = clicksNumerator / clicksDenominator

        val clicksRoundUP = kotlin.math.round(clicks)

        binding.clicksDisplay.text = " ${clicksRoundUP} "

    }
}



