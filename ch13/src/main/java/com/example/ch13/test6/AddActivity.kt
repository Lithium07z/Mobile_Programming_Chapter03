package com.example.ch13.test6

import android.app.Activity
import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.DatePicker
import com.example.ch13.R
import com.example.ch13.databinding.ActivityAddBinding
import java.util.Calendar

class AddActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityAddBinding.inflate(layoutInflater)
        setContentView(binding.root)

        DatePickerDialog(this, { view, year, month, dayOfMonth ->
            binding.dateTxt.text = "$year 년 ${month + 1} 월 $ $dayOfMonth 일"
            val pickedDate = "($year/${month + 1}/$dayOfMonth)"
            intent.putExtra("data", pickedDate)
        }, Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH)).show()

        binding.saveBtn.setOnClickListener {
            intent.putExtra("result", binding.editTxtView.text.toString())
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}