package com.example.ch13.test4

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import com.example.ch13.R
import com.example.ch13.databinding.ActivityExample4aBinding

class Example4aActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityExample4aBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val manager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

        binding.showBtn.setOnClickListener {
            binding.edtText.requestFocus()
            manager.showSoftInput(binding.edtText, InputMethodManager.SHOW_IMPLICIT)
        }

        binding.hideBtn.setOnClickListener {
            manager.hideSoftInputFromWindow(currentFocus?.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
        }
    }
}