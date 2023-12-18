package com.ch15.ch14.test3

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.ch14.R
import com.example.ch14.databinding.ActivityExample3Binding

class Example3Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityExample3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val batteryStatus = registerReceiver(null, IntentFilter(Intent.ACTION_BATTERY_CHANGED))
        val status = batteryStatus?.getIntExtra(BatteryManager.EXTRA_STATUS, -1)
        val pluggedStatus = batteryStatus?.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1)

        when(status) {
            BatteryManager.BATTERY_STATUS_CHARGING -> {
                when (pluggedStatus) {
                    BatteryManager.BATTERY_PLUGGED_USB -> {
                        binding.charginResultTxt.text = "USB로 충전 중"
                        binding.chargingImg.setImageResource(R.drawable.usb)
                    }

                    BatteryManager.BATTERY_PLUGGED_AC -> {
                        binding.charginResultTxt.text = "AC로 충전 중"
                        binding.chargingImg.setImageResource(R.drawable.ac)
                    }
                }
            }
            else -> binding.charginResultTxt.text = "충전 상태가 아님"
        }

        val level = batteryStatus!!.getIntExtra(BatteryManager.EXTRA_LEVEL, -1)
        val scale = batteryStatus!!.getIntExtra(BatteryManager.EXTRA_SCALE, -1)
        var batteryPercent = level / scale.toFloat() * 100
        binding.percentResultTxt.text = "${batteryPercent} %"

        binding.btn.setOnClickListener {
            val intent = Intent(this, MyReceiver::class.java).apply {
                val chargingResult = if (status == BatteryManager.BATTERY_STATUS_CHARGING) {
                    "충전 중 입니다."
                } else {
                    "충전 중이 아닙니다."
                }
                putExtra("chargingResult", "$chargingResult")
                putExtra("percentResult", "$batteryPercent")
            }
            sendBroadcast(intent)
        }

        val receiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {
                Toast.makeText(context, "배터리 상태가 변경되었습니다.", Toast.LENGTH_SHORT).show()
            }
        }

        val filter = IntentFilter().apply {
            addAction(Intent.ACTION_BATTERY_CHANGED)
        }
        registerReceiver(receiver, filter)
    }
}