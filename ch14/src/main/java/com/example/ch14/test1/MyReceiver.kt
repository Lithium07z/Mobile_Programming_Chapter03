package com.example.ch14.test1

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val data = intent.getStringExtra("key")
        Toast.makeText(context, "${data}에서 브로드캐스트 리시버 실행", Toast.LENGTH_SHORT).show()
    }
}