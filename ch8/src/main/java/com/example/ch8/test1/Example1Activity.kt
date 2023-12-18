package com.example.ch8.test1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import com.example.ch8.R

class Example1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_example1)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when(event?.action) {
            MotionEvent.ACTION_DOWN -> { Log.d("mop", "touch down x:${event.x}, rawX:${event.rawX}") }
            MotionEvent.ACTION_UP -> { Log.d("mop", "touch up y:${event.y}, rawY:${event.rawY}") }
        }

        return super.onTouchEvent(event)
    }
}