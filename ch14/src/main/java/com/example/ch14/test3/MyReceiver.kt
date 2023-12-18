package com.ch15.ch14.test3

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val data1 = intent.getStringExtra("chargingResult")
        val data2 = intent.getStringExtra("percentResult")
        Toast.makeText(context, "(배터리 $data2 %) $data1", Toast.LENGTH_SHORT).show()
    }
}