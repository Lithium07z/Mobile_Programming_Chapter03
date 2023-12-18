package com.example.ch_15_outter

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.Handler
import android.os.IBinder
import android.os.Looper
import android.os.Message
import android.os.Messenger
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.ch15.MyAIDL
import com.example.ch_15_outter.R
import com.example.ch_15_outter.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var connectionMode = "none"

    /*--------------------------------------------*/
    /* 1. 메신저 방법으로 연동 */
    /*--------------------------------------------*/
    lateinit var messenger: Messenger // 서비스 > 액티비티
    lateinit var replyMessenger: Messenger // 액티비티 > 서비스
    var messengerJob: Job? = null

    //메신저 핸들러 ......................
    inner class HandlerReplyMsg: Handler(Looper.getMainLooper()) {
        override fun handleMessage(msg: Message) {
            when (msg.what) {
                10 -> {
                    val bundle = msg.obj as Bundle
                    bundle.getInt("duration")?.let {
                        when {
                            it > 0 -> {
                                binding.messengerProgress.max = it
                                val backgroundScope = CoroutineScope(Dispatchers.Default + Job())
                                messengerJob = backgroundScope.launch {
                                    while (binding.messengerProgress.progress < binding.messengerProgress.max) {
                                        delay(1000)
                                        binding.messengerProgress.incrementProgressBy(1000)
                                    }
                                }
                                changeViewEnable()
                            }
                            else -> {
                                connectionMode = "none"
                                unbindService(messengerConnection)
                                changeViewEnable()
                            }
                        }
                    }
                }
            }
            super.handleMessage(msg)
        }
    }

    //메신저 커넥션.......................
    val messengerConnection: ServiceConnection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            val msg = Message().apply {
                what = 10
                replyTo = replyMessenger
            }
            messenger = Messenger(service)
            messenger.send(msg)
            connectionMode = "messenger"
        }

        override fun onServiceDisconnected(name: ComponentName?) {

        }
    }

    //메신저 전용 개발자 함수..............
    private fun onCreateMessengerService() {
        replyMessenger = Messenger(HandlerReplyMsg())
        binding.messengerPlay.setOnClickListener {
            val intent = Intent("ACTION_SERVICE_MESSENGER")
            intent.setPackage("com.example.ch15")
            bindService(intent, messengerConnection, Context.BIND_AUTO_CREATE)
        }
        binding.messengerStop.setOnClickListener {
            val msg = Message().apply {
                what = 20
            }
            messenger.send(msg)
            unbindService(messengerConnection)
            messengerJob?.cancel()
            changeViewEnable()
        }
    }

    /*--------------------------------------------*/
    /* 2. AIDL 방법으로 연동 */
    /*--------------------------------------------*/
    var aidlService: MyAIDL? = null
    var aidlJob: Job? = null

    //AIDL 커넥션 .......................
    val aidlConnection: ServiceConnection = object : ServiceConnection {

        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            aidlService = MyAIDL.Stub.asInterface(service)
            aidlService!!.start()
            binding.aidlProgress.max = aidlService!!.maxDuration
            val backgorundScope = CoroutineScope(Dispatchers.Default + Job())
            aidlJob = backgorundScope.launch {
                while (binding.aidlProgress.progress < binding.aidlProgress.max) {
                    delay(1000)
                    binding.aidlProgress.incrementProgressBy(1000)
                }
            }
            connectionMode = "aidl"
            changeViewEnable()
        }

        override fun onServiceDisconnected(name: ComponentName?) {
            aidlService = null
        }
    }

    //AIDL 전용 개발자 함수...............
    private fun onCreateAIDLService() {
        binding.aidlPlay.setOnClickListener {
            val intent = Intent("ACTION_SERVICE_AIDL")
            intent.setPackage("com.example.ch15")
            try {
                bindService(intent, aidlConnection, Context.BIND_AUTO_CREATE)
            } catch (e: Exception) {
                Log.d("mop", e.toString())
            }
        }
        binding.aidlStop.setOnClickListener {
            aidlService!!.stop()
            unbindService(aidlConnection)
            aidlJob?.cancel()
            connectionMode = "none"
            changeViewEnable()
        }
    }


    /*--------------------------------------------*/
    /* 생명 주기 함수 */
    /*--------------------------------------------*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //1. 메신저 방법으로 연동
        onCreateMessengerService()

        //2. AIDL 방법으로 연동
        onCreateAIDLService()
    }

    /*-----------------------------------------*/
    /* 개발자 함수 */
    /*-----------------------------------------*/
    // 모드에 따른 버튼 활성화 설정 함수
    fun changeViewEnable() = when (connectionMode) {
        "messenger" -> {
            binding.messengerPlay.isEnabled = false
            binding.aidlPlay.isEnabled = false
            binding.messengerStop.isEnabled = true
            binding.aidlStop.isEnabled = false
        }

        "aidl" -> {
            binding.messengerPlay.isEnabled = false
            binding.aidlPlay.isEnabled = false
            binding.messengerStop.isEnabled = false
            binding.aidlStop.isEnabled = true
        }

        else -> {
            //초기상태. stop 상태. 두 play 버튼 활성상태
            binding.messengerPlay.isEnabled = true
            binding.aidlPlay.isEnabled = true
            binding.messengerStop.isEnabled = false
            binding.aidlStop.isEnabled = false

            binding.messengerProgress.progress = 0
            binding.aidlProgress.progress = 0
        }
    }
}