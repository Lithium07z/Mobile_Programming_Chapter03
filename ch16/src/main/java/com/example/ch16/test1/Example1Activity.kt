package com.example.ch16.test1

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.ch16.R
import com.example.ch16.databinding.ActivityExample1Binding

class Example1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityExample1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn.setOnClickListener {
            val cursor = contentResolver.query(
                Uri.parse("content://com.mop.provider"),
                null, null, null, null, null
            )
            while (cursor?.moveToNext() ?: false) {
                Log.d("mop", cursor?.getString(0) ?: "null")
                Log.i("mop", cursor?.getString(1) ?: "null")
            }
        }
    }
}