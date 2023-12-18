package com.example.ch6.example5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.ch6.R
import com.example.ch6.databinding.ActivityExample5Binding

class Example5Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_example5)

        val binding = ActivityExample5Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.visibleBtn.setOnClickListener {
            binding.targetView.visibility = View.VISIBLE
        }

        binding.invisibleBtn.setOnClickListener {
            binding.targetView.visibility = View.INVISIBLE
        }
    }
}