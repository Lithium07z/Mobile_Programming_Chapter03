package com.example.ch16.test3

import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.FileProvider
import com.example.ch16.R
import com.example.ch16.databinding.ActivityExample1Binding
import com.example.ch16.databinding.ActivityExample3Binding
import java.io.File
import java.text.SimpleDateFormat
import java.util.Date

class Example3Activity : AppCompatActivity() {
    lateinit var binding: ActivityExample3Binding
    lateinit var filePath: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExample3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        /**
         *--------------------------------------------
         * 갤러리 앱 실행 런처
         *--------------------------------------------
         **/
        val requestGalleryLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) {
            val calRatio = calculateInSampleSize(
                it.data!!.data!!,
                resources.getDimensionPixelSize(R.dimen.imgSize),
                resources.getDimensionPixelSize(R.dimen.imgSize)
            )

            val option = BitmapFactory.Options()
            option.inSampleSize = calRatio
            var inputStream = contentResolver.openInputStream(it.data!!.data!!)
            val bitmap = BitmapFactory.decodeStream(inputStream, null, option)
            inputStream!!.close()
            inputStream = null

            bitmap?.let {
                binding.userImg.setImageBitmap(it)
            } ?: let {
                Log.d("mop", "bitmap: NULL")
            }
        }

        binding.galleryBtn.setOnClickListener {
            val intent = Intent(
                Intent.ACTION_PICK,
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            )
            intent.type = "image/*"
            requestGalleryLauncher.launch(intent)
        }

        /**
         *--------------------------------------------
         * 카메라 앱 실행 런처
         *--------------------------------------------
         **/

        val requestCameraLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) {
            val calRatio = calculateInSampleSize(
                Uri.fromFile((File(filePath))),
                resources.getDimensionPixelSize(R.dimen.imgSize),
                resources.getDimensionPixelSize(R.dimen.imgSize)
            )
            val option = BitmapFactory.Options().apply {
                inSampleSize = calRatio
            }
            val bitmap = BitmapFactory.decodeFile(filePath, option)?.let {
                binding.userImg.setImageBitmap(it)
            }
        }
        binding.cameraBtn.setOnClickListener {
            val timestamp = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
            val storagDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
            val file = File.createTempFile(
                "JPEG_${timestamp}",
                ".jpg",
                storagDir
            )
            filePath = file.absolutePath
            val photoURI = FileProvider.getUriForFile(
                this,
                "com.example.ch16.fileprovider",
                file
            )
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE).apply {
                putExtra(MediaStore.EXTRA_OUTPUT, photoURI)
            }
            requestCameraLauncher.launch(intent)
        }
    }


    /**
     * 이미지 비율 계산
     * fileUri 원본 이미지의 식별자 Uri
     * reqWidth 지정하려는 이미지 가로 사이즈
     * reqHeight 지정하려는 이미지 세로 사이즈
     **/
    private fun calculateInSampleSize(fileUri: Uri, reqWidth: Int, reqHeight: Int): Int {
        val options = BitmapFactory.Options()
        options.inJustDecodeBounds = true
        try {
            var inputStream = contentResolver.openInputStream(fileUri)

            BitmapFactory.decodeStream(inputStream, null, options)
            inputStream!!.close()
            inputStream = null
        } catch (e: Exception) {
            e.printStackTrace()
        }
        val (height: Int, width: Int) = options.run { outHeight to outWidth }
        var inSampleSize = 1

        if (height > reqHeight || width > reqWidth) {

            val halfHeight: Int = height / 2
            val halfWidth: Int = width / 2

            while (halfHeight / inSampleSize >= reqHeight && halfWidth / inSampleSize >= reqWidth) {
                inSampleSize *= 2
            }
        }
        return inSampleSize
    }
}