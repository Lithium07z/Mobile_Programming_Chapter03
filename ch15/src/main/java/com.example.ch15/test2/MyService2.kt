package com.example.ch15.test2

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log

class MyService2 : Service() {

    class MyBinder : Binder() {
        fun funA(arg: Int) {
            Log.d("mop", "funA($arg) 실행")
        }
        fun funB(arg: Int): Int {
            Log.d("mop", "funB($arg) 실행")
            return arg * arg
        }
    }

    override fun onBind(intent: Intent): IBinder {
        return MyBinder()
    }
}