package com.example.ch15.test4

import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.content.ComponentName
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import com.example.ch15.databinding.ActivityExample4Binding

class Example4Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityExample4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn.setOnClickListener {
            val scheduler = getSystemService(Context.JOB_SCHEDULER_SERVICE) as JobScheduler
            val extras = PersistableBundle().apply {
                putString("extra_data", "모바일 프로그래밍")
            }

            val builder = JobInfo.Builder(1,
                ComponentName(this, MyJobService::class.java)
            ).apply {
                setRequiredNetworkType(JobInfo.NETWORK_TYPE_UNMETERED)
                setExtras(extras)
            }

            scheduler.schedule(builder.build())
        }
    }
}