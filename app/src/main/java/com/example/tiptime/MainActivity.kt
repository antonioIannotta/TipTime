package com.example.tiptime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tiptime.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.calculateButton.setOnClickListener { calculateTip() }
    }

    fun calculateTip() {

        val costOfService = binding.costOfService.text.toString().toDouble()
        var tipPercentage: Double = 0.0

        when (binding.tipOptions.checkedRadioButtonId) {
            R.id.amazing_option -> tipPercentage = 0.20
            R.id.good_option -> tipPercentage = 0.18
            R.id.okay_option -> tipPercentage = 0.15
        }

        var tip: Double = tipPercentage * costOfService

        if (binding.roundUpSwitch.isChecked) {
            tip = kotlin.math.ceil(tip)
        }

        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)

        binding.tipResult.text = getString(R.string.tip_amount, formattedTip)
    }
}