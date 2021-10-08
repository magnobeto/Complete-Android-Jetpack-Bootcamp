package com.anushka.bindingdemo3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.anushka.bindingdemo3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        val student =getStudent()
        binding.nameText.text = student.name
        binding.emailText.text = student.email
    }

    private fun getStudent():Student{
        return Student(1,"Alex","alex@gmail.com")
    }
}
