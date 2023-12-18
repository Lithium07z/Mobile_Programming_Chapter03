package com.example.ch15.test5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ch15.R
import com.example.ch15.databinding.ActivityExample5Binding

class Example5Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityExample5Binding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}