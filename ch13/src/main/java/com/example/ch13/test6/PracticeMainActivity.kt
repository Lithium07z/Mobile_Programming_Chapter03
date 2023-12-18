package com.example.ch13.test6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.GridLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.view.setPadding
import com.example.ch13.R
import com.example.ch13.databinding.ActivityPracticeMainBinding
import com.example.ch13.test6.AddActivity

class PracticeMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityPracticeMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var data1 : String? = null  // 날짜 저장할 변수
        var data2 : String? = null  // 내용 저장할 변수

        val reqLauncher: ActivityResultLauncher<Intent> = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) {
            // 사후 처리 로직 작성
            it.data?.getStringExtra("data")?.let {
                data1 = it
            }
            it.data?.getStringExtra("result").let {
                data2 = it
            }

            val imgView = ImageView(this)
            imgView.setImageResource(R.drawable.todo)
            imgView.setPadding(15)
            binding.gridlayout.addView(imgView)

            val txtView = TextView(this).apply {
                text = "$data1 $data2"
                textSize = 20f
                setPadding(15, 15, 15, 15)
            }

            val rowSpec = GridLayout.spec(GridLayout.UNDEFINED, 1f)
            val colSpec = GridLayout.spec(GridLayout.UNDEFINED, 1f)
            txtView.layoutParams = GridLayout.LayoutParams(rowSpec, colSpec)
            binding.gridlayout.addView(txtView)
        }

        binding.addBtn.setOnClickListener {
            val intent = Intent(this, AddActivity::class.java)
            reqLauncher.launch(intent)
        }
    }
}