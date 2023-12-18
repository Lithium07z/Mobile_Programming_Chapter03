package com.example.ch13.test1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.ch13.DetailActivity
import com.example.ch13.databinding.ActivityExample1Binding

class Example1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityExample1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val requestLauncher : ActivityResultLauncher<Intent> = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) {
            // 돌아왔을 때 콜백함수
            val resultData = it.data?.getStringExtra("result")
            binding.txtView.text = "전달 받은 결과는 $resultData 입니다."
        }

        binding.button.setOnClickListener {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("key1", "안녕하세요")
            intent.putExtra("key2", 10)
            requestLauncher.launch(intent)
        }
    }
}