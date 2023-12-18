package com.example.ch7.test3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.ch7.R
import com.example.ch7.databinding.ActivityExample1Binding
import com.example.ch7.databinding.ActivityExample3Binding

class Example3Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityExample3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn.setOnClickListener {
            binding.btn.visibility = View.INVISIBLE
            binding.imageB.visibility = View.VISIBLE
        }

        binding.imageB.setOnClickListener {
            binding.btn.visibility = View.VISIBLE
            binding.imageB.visibility = View.INVISIBLE
        }
    }
}