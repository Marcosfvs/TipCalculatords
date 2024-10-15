package com.example.tipcalculatords

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tipcalculatords.databinding.ActivitySummaryBinding

class SummaryActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySummaryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySummaryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val totalTable = intent.getFloatExtra("totalTable", 0.0f)
        val numPeople = intent.getIntExtra("numPeople", 0)
        val percentage = intent.getIntExtra("percentage",0)
        val totalAmount = intent.getFloatExtra("totalAmount",0.0f)

        binding.tvPercentage.text = percentage.toString()
        binding.tvTotalTable.text = totalTable.toString()
        binding.tvNumPeople.text = numPeople.toString()
        binding.tvTotalAmount.text = totalAmount.toString()

        binding.btnRefresh.setOnClickListener {
            finish()
            //val intent = Intent (this, MainActivity::class.java)
            //startActivity(intent)
        }
    }
}
