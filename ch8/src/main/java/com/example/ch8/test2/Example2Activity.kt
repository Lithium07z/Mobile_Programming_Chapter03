package com.example.ch8.test2

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.CompoundButton
import android.widget.RadioGroup.OnCheckedChangeListener
import android.widget.Toast
import com.example.ch8.R
import com.example.ch8.databinding.ActivityExample2Binding

class Example2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityExample2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // 방법1: 외부에서 핸들러 정의
        // binding.checkView.setOnCheckedChangeListener(MyHandler())

        // 방법2: 익명 클래스로 핸들러 정의
//        binding.checkView.setOnCheckedChangeListener(object : CompoundButton.OnCheckedChangeListener {
//            override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
//                Log.d("mop", "체크 박스 클릭...${isChecked}")
//                Log.e("mop", "object 클래스 이용")
//            }
//        })

        // 방법3: SAM 기법 (람다 함수)
        binding.checkView.setOnCheckedChangeListener { buttonView, isChecked ->
            Log.d("mop", "체크 박스 클릭...${isChecked}")
            Log.e("mop", "SAM 기법 이용")
        }

        binding.btnView.setOnClickListener(MyHandler2(this))

    }
}

class MyHandler : CompoundButton.OnCheckedChangeListener {
    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
        Log.d("mop", "체크 박스 클릭...${isChecked}")
    }
}

class MyHandler2(val context: Context) : OnClickListener {
    override fun onClick(v: View?) {
        Toast.makeText(context, "버튼 클릭", Toast.LENGTH_LONG).show()
    }
}