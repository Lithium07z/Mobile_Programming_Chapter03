package com.example.ch16.test2

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import com.example.ch16.R
import com.example.ch16.databinding.ActivityExample2Binding

class Example2Activity : AppCompatActivity() {
    lateinit var intentLauncher: ActivityResultLauncher<Intent>
    lateinit var binding: ActivityExample2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExample2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        intentLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) {
            if (it.resultCode == Activity.RESULT_OK) {
                Log.d("mop", "${it?.data?.data}")
                val cursor = contentResolver.query(
                    it!!.data!!.data!!,
                    arrayOf(
                        ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
                        ContactsContract.CommonDataKinds.Phone.NUMBER,
                    ),
                    null,
                    null,
                    null
                )
                if (cursor!!.moveToFirst()) {
                    binding.txtView.text = "이름: ${cursor?.getString(0)}, 번호: ${cursor?.getString(1)}"
                }
            }
        }

        val permissionLauncher = registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ) {
            for (entry in it.entries) {
                if (entry.key == "android.permission.READ_CONTACTS" && entry.value) {
                    val intent = Intent(
                        Intent.ACTION_PICK,
                        ContactsContract.CommonDataKinds.Phone.CONTENT_URI
                    )
                    intentLauncher.launch(intent)
                } else {
                    Toast.makeText(this, "퍼미션이 필요합니다.", Toast.LENGTH_SHORT).show()
                }
            }
        }

        binding.btn.setOnClickListener {
            // 퍼미션이 부여되지 않은 상태라면
            if (ContextCompat.checkSelfPermission(this, "android:permission.READ_CONTACTS") != PackageManager.PERMISSION_GRANTED) {
                permissionLauncher.launch(arrayOf("android.permission.READ_CONTACTS"))
            } else {
                val intnet = Intent(
                    Intent.ACTION_PICK,
                    ContactsContract.CommonDataKinds.Phone.CONTENT_URI
                )
                intentLauncher.launch(intent)
            }
        }
    }
}