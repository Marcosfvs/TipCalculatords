package com.example.tipcalculatords

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tipcalculatords.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.btnDone.setOnClickListener {
            val percentage: Int = binding.tiePercentage.text.toString().toInt()
            val totalTable: Float = binding.tieTotal.text.toString().toFloat()
            val npeople: Int = binding.tieNumberOfPeople.text.toString().toInt()
            val totalTemp = totalTable / npeople
            val tips= percentage / 100
            val totalWithTips = totalTemp + tips
        }
        binding.btnClean.setOnClickListener {

        }
    }
}