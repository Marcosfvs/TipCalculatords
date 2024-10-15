package com.example.tipcalculatords

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tipcalculatords.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnDone.setOnClickListener {
            val textPercentage = binding.tiePercentage.text.toString()
            val textTotalTable = binding.tieTotal.text.toString()
            val textNPeople = binding.tieNumberOfPeople.text.toString()

            if (textPercentage.isEmpty() || textTotalTable.isEmpty() || textNPeople.isEmpty()
            ) {
                Snackbar.make(binding.tieTotal, "Preencha todos os campos", Snackbar.LENGTH_LONG)
                    .show()
            } else {
                val percentage: Int = textPercentage.toInt()
                val totalTable: Float = textTotalTable.toFloat()
                val npeople: Int = textNPeople.toInt()
                val totalTemp = totalTable / npeople
                val tips = totalTemp * percentage / 100
                val totalWithTips = totalTemp + tips
                val intent = Intent(this, SummaryActivity::class.java)
                    .apply {
                        putExtra("totalTable", totalTable)
                        putExtra("percentage", percentage)
                        putExtra("numPeople", npeople)
                        putExtra("totalAmount", totalWithTips)
                    }
                clean()
                startActivity(intent)
            }
        }

        binding.btnClean.setOnClickListener {
            clean()
        }
    }
    private fun clean(){
        binding.tieTotal.setText("")
        binding.tiePercentage.setText("")
        binding.tieNumberOfPeople.setText("")
    }
}