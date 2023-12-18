package com.example.ch15.test2

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import com.example.ch15.databinding.ActivityExample2Binding

class Example2Activity : AppCompatActivity() {

    lateinit var serviceBinder : MyService2.MyBinder

    val connection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            serviceBinder = service as MyService2.MyBinder
        }

        override fun onServiceDisconnected(name: ComponentName?) {
            TODO("Not yet implemented")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityExample2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = Intent(this, MyService2::class.java)
        bindService(intent, connection, Context.BIND_AUTO_CREATE)

        binding.btn1.setOnClickListener {
            serviceBinder.funA(10)
        }
        binding.btn2.setOnClickListener {
            Log.d("mop", "${serviceBinder.funB(100)}")
        }
    }
}