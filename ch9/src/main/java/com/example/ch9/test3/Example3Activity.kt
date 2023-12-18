package com.example.ch9.test3

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import android.view.WindowMetrics
import com.example.ch9.R
import kotlin.math.log

class Example3Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_example3)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            val windowMetrics : WindowMetrics = windowManager.currentWindowMetrics
            Log.d("mop", "width: ${windowMetrics.bounds.width()}")
            Log.d("mop", "height: ${windowMetrics.bounds.height()}")
        } else {
            val display = windowManager.defaultDisplay
            val displayMetrics = DisplayMetrics()
            display?.getRealMetrics(displayMetrics)
            Log.d("mop", "width: ${displayMetrics.widthPixels}")
            Log.d("mop", "height: ${displayMetrics.heightPixels}")
        }
    }
}