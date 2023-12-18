package com.example.ch13.test2

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.ch13.R
import com.example.ch13.databinding.ActivityExample2Binding
import java.lang.Exception

class Example2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityExample2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn1.setOnClickListener{
            // 인텐트 생성 방법1
           // val intent = Intent("ACTION_EDIT", Uri.parse("https://www.hallym.ac.kr"))

            // 인텐트 생성 방법2
//            val intent = Intent()
//            intent.action = "ACTION_EDIT"
//            intent.action = "ACTION_VIEW"
//            intent.addCategory("CATEGORY_TEST")
//            intent.addCategory("android.intent.category.HOME")
//            intent.data = Uri.parse("https://www.hallym.ac.kr")

            // 인텐트 생성 방법3
            val intent = Intent().apply {
                action = "ACTION_EDIT"
                action = "ACTION_VIEW"
                data = Uri.parse("https://www.hallym.ac.kr")
                addCategory("CATEGORY_TEST")
            }

            try {
                startActivity(intent)
            } catch (e: Exception) {
                Toast.makeText(this, "인텐트로 실행할 수 있는 액티비티가 없습니다.", Toast.LENGTH_LONG).show()
            }
        }

        binding.btn2.setOnClickListener {
            // 지도 호출
            //val intent = Intent(Intent.ACTION_VIEW, Uri.parse("geo:37.89, 127.74"))
 
            // 갤러리 호출
//            val intent = Intent().apply {
//                action = Intent.ACTION_PICK
//                type = "image/*"
//            }

            // 전화 걸기 화면 호출
            val intent = Intent()
            intent.action = Intent.ACTION_DIAL
            intent.data = Uri.parse("tel:033-248-2334")

            startActivity(intent)
        }
    }
}