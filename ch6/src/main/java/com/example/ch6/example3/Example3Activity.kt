package com.example.ch6.example3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.ch6.R

class Example3Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_example3)

        val btn1 = findViewById<Button>(R.id.button1)
        val btn2 = findViewById<Button>(R.id.button2)
        val btn3 = findViewById<Button>(R.id.button3)
        val btn4 = findViewById<Button>(R.id.button4)
        val btn5 = findViewById<Button>(R.id.button5)
        val btn6 = findViewById<Button>(R.id.button6)

        btn1.setOnClickListener {
            btn2.visibility = View.VISIBLE
        }

        btn3.setOnClickListener {
            btn2.visibility = View.INVISIBLE
        }

        btn4.setOnClickListener {
            btn5.visibility = View.VISIBLE
        }

    }
}