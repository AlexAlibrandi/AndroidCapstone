package com.android.capstone.activities
import com.android.capstone.databinding.LineChartActivityBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.android.capstone.R


private lateinit var binding : LineChartActivityBinding

class LineChartActivity : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = LineChartActivityBinding.inflate(layoutInflater)
            setContentView(binding.root)

            val intentValue = intent.getStringExtra("Confidence")

            binding.receivedValueId.apply{
                text = intentValue
            }

        }

    }