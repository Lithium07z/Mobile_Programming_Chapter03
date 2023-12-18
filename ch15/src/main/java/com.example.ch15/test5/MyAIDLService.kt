package com.example.ch15.test5

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.util.Log
import com.example.ch15.R
import com.example.ch15.MyAIDL

class MyAIDLService : Service() {

    lateinit var player: MediaPlayer

    override fun onCreate() {
        super.onCreate()
        player = MediaPlayer()
        Log.d("mop", "서비스 시작")
    }

    override fun onDestroy() {
        super.onDestroy()
        player.release()
        Log.d("mop", "서비스 종료")
    }

    override fun onBind(intent: Intent): IBinder {
        return object: MyAIDL.Stub() {
            override fun getMaxDuration(): Int {
                return if (player.isPlaying) {
                    player.duration
                } else {
                    0
                }
            }

            override fun start() {
                if (!player.isPlaying) {
                    player = MediaPlayer.create(
                        this@MyAIDLService, R.raw.music)
                    player.start()
                }
            }

            override fun stop() {
                if (player.isPlaying) {
                    player.stop()
                }
            }
        }
    }
}