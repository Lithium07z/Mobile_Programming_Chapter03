package com.example.ch14.test1

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ch14.R
import com.example.ch14.databinding.ActivityExample1Binding

class Example1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityExample1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val intent = Intent(this, MyReceiver::class.java)
            intent.putExtra("key", "액티비티")
            sendBroadcast(intent)
        }
    }
}