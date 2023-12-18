package com.example.ch15.test3

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.IBinder
import android.os.Looper
import android.os.Message
import android.os.Messenger
import com.example.ch15.databinding.ActivityExample3Binding

class Example3Activity : AppCompatActivity() {
    lateinit var messenger: Messenger
    lateinit var replyMessenger: Messenger
    lateinit var binding: ActivityExample3Binding

    val connection : ServiceConnection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            messenger = Messenger(service)

            val bundle = Bundle().apply {
                putInt("input", 100)
            }

            val msg = Message().apply {
                what = 1
                obj =bundle
                replyTo = replyMessenger
            }
            messenger.send(msg)
        }

        override fun onServiceDisconnected(name: ComponentName?) {

        }
    }

    inner class toActivityHandler: Handler(Looper.getMainLooper()) {
        override fun handleMessage(msg: Message) {
            when (msg.what) {
                5 -> {
                    val receivedBundle = msg.obj as? Bundle
                    binding.txtView2.text = "2. 서비스로부터 " + receivedBundle?.getInt("result").toString() + " 받았습니다."
                    val replyMsg = Message().apply {
                        what = 10
                        replyTo = replyMessenger
                    }
                    val replyMessenger2 = msg.replyTo
                    replyMessenger2.send(replyMsg)
                    binding.txtView3.text = "3. 서비스에게 다시 메세지를 보냈습니다."
                }
            }

            super.handleMessage(msg)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExample3Binding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
        replyMessenger = Messenger(toActivityHandler())
        binding.btn.setOnClickListener {
            val intent = Intent(this, MyService3::class.java)
            bindService(intent, connection, Context.BIND_AUTO_CREATE)
            binding.txtView1.text = "1. 서비스에게 메세지를 보냈습니다."
        }
    }
}