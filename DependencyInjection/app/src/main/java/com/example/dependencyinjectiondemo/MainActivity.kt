package com.example.dependencyinjectiondemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    private lateinit var smartPhone: SmartPhone

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val smartPhone = SmartPhone(
//            Battery(),
//            SIMCard(ServiceProvider()),
//            MemoryCard()
//        )
//        smartPhone.makeACallWithRecording()
    }
}