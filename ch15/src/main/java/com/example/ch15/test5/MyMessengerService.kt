package com.example.ch15.test5

import android.app.Service
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.os.Build.VERSION_CODES.P
import android.os.Bundle
import android.os.Handler
import android.os.IBinder
import android.os.Looper
import android.os.Message
import android.os.Messenger
import com.example.ch15.R

class MyMessengerService : Service() {

    lateinit var player: MediaPlayer
    lateinit var messenger: Messenger // 액티비티 > 서비스
    lateinit var replyMessenger: Messenger // 서비스 > 액티비티

    override fun onCreate() {
        super.onCreate()
        player = MediaPlayer()
    }

    override fun onDestroy() {
        super.onDestroy()
        player.release()
    }

    inner class IncomingHandler(context: Context, private val applicationContext: Context = context.applicationContext) : Handler(Looper.getMainLooper()) {
        override fun handleMessage(msg: Message) {
            when (msg.what) {
                10 -> {
                    replyMessenger = msg.replyTo // 답장을 보낼 수 있는 메신저, 액티비티가 지정을 미리 해놓음
                    if (!player.isPlaying) {
                        player = MediaPlayer.create(this@MyMessengerService, R.raw.music)
                        val replyBundle = Bundle().apply {
                            putInt("duration", player.duration)
                        }
                        val replyMsg = Message().apply {
                            what = 10
                            obj = replyBundle
                        }
                        replyMessenger.send(replyMsg)
                        player.start()
                    }
                }

                20 -> {
                    if (player.isPlaying) {
                        player.stop()
                    }
                }
                else -> super.handleMessage(msg)
            }
        }
    }

    override fun onBind(intent: Intent): IBinder {
        messenger = Messenger(IncomingHandler(this))
        return messenger.binder
    }
}