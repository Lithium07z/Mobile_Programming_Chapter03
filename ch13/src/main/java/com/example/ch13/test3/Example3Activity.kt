package com.example.ch13.test3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import com.example.ch13.R
import com.example.ch13.databinding.ActivityExample3Binding

class Example3Activity : AppCompatActivity() {
    var count = 0
    lateinit var binding : ActivityExample3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityExample3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.countBtn.setOnClickListener {
            count++
            binding.resultTxtView.text = "$count"
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("count", count)
    }

    override fun onRestoreInstanceState(
        savedInstanceState: Bundle
    ) {
        super.onRestoreInstanceState(savedInstanceState)
        val data = savedInstanceState.getInt("count")
        binding.resultTxtView.text = "$data"
        count = data
    }
}