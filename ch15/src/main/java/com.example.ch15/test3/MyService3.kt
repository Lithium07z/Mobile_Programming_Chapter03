package com.example.ch15.test3

import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.IBinder
import android.os.Looper
import android.os.Message
import android.os.Messenger
import android.widget.Toast

class MyService3 : Service() {

    lateinit var messenger: Messenger

    inner class toServiceHandler(context: Context, private val applicationContext: Context = context.applicationContext):
    Handler(Looper.myLooper()!!) {
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            var receivedBundle = msg.obj as? Bundle
            when (msg.what) {
                1 -> {
                    val replyBundle = Bundle().apply {
                        putInt("result", receivedBundle?.getInt("input")!!.times(100))
                    }
                    val replyMsg = Message().apply {
                        what = 5
                        obj = replyBundle
                        replyTo = messenger
                    }
                    val replyMessenger = msg.replyTo
                    replyMessenger.send(replyMsg)
                }
                10 -> {
                    Toast.makeText(applicationContext, "서비스가 데이터를 전달 받았습니다.", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    super.handleMessage(msg)
                }
            }
        }
    }

    override fun onBind(intent: Intent): IBinder {
        messenger = Messenger(toServiceHandler(this))
        return messenger.binder
    }
}