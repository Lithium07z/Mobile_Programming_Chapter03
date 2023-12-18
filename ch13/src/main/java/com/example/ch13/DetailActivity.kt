package com.example.ch13

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ch13.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data1 = intent.getStringExtra("key1")
        val data2 = intent.getIntExtra("key2", 100)

        binding.detailBtn.setOnClickListener {
            binding.textView.text = "$data1, $data2"
        }

        binding.detailBtn.setOnLongClickListener{
            intent.putExtra("result", "디테일")
            setResult(Activity.RESULT_OK, intent)
            finish()
            true
        }
    }
}