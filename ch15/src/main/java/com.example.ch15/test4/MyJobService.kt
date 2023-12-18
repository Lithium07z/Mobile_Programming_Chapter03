package com.example.ch15.test4

import android.app.Service
import android.app.job.JobParameters
import android.app.job.JobService
import android.content.Intent
import android.os.IBinder
import android.os.SystemClock
import android.util.Log
import kotlin.concurrent.thread

class MyJobService : JobService() {
    override fun onCreate() {
        super.onCreate()
        Log.d("mop", "잡 서비스 실행")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("mop", "잡 서비스 종료")
    }

    override fun onStartJob(params: JobParameters?): Boolean {
        val param = params?.extras?.getString("extra_data")
        Log.d("mop", "동작 중 with $param")

        thread {
            var sum = 0
            var str = "계산 중"

            for (i in  1..5) {
                SystemClock.sleep(1000)
                sum += i
                str += "."
                Log.d("mop", str)
            }
            Log.d("mop", "업무 종료, 결과 $sum")
            jobFinished(params, false)
        }

        return true
    }

    override fun onStopJob(params: JobParameters?): Boolean {
        Log.e("mop", "onStopJob 실행")
        return false
    }
}