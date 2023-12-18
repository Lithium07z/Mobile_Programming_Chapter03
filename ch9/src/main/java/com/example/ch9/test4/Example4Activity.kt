package com.example.ch9.test4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.widget.Toast
import com.example.ch9.R

class Example4Activity : AppCompatActivity() {
    var keyDownTime = 0L // 백버튼 누른 시점을 저장

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_example4)
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            // 처음 버튼이 눌렸거나 누른지 3초가 지났다면
            if (System.currentTimeMillis() - keyDownTime > 3000) {
                Toast.makeText(this, "종료하려면 한번 더 누르세요", Toast.LENGTH_SHORT).show()
                keyDownTime = System.currentTimeMillis()
                return true
            }
        }
        
        // 3초 이내 눌렀다면
        return super.onKeyDown(keyCode, event)
    }
}