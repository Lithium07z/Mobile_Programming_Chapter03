package com.example.ch13.test5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ch13.R
import com.example.ch13.databinding.ActivityExample5Binding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.launch
import kotlin.system.measureTimeMillis

class Example5Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityExample5Binding.inflate(layoutInflater)
        setContentView(binding.root)

//        var sum = 0L
//        binding.button.setOnClickListener {
//            var time = measureTimeMillis {
//                for (i in 1 .. 15_000_000_000) {
//                    sum += i
//                }
//            }
//            binding.textView.text = "계산 시간: ${time / 1000.toFloat()}초"
//        }

        binding.button.setOnClickListener {
            val channel = Channel<Long>()
            val backgroundscope = CoroutineScope(Dispatchers.Default + Job())
            backgroundscope.launch {
                var sum = 0L
                var time = measureTimeMillis {
                    for (i in 1 .. 15_000_000_000) {
                        sum += i
                    }
                }
                channel.send(time)
            }

            GlobalScope.launch(Dispatchers.Main) {
                channel.consumeEach {
                    binding.textView.text = "계산 시간: ${it/1000.toFloat()}초"
                }
            }
        }
    }
}