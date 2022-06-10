package com.example.dependencyinjectiondemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val simCard = SIMCard().apply {
            setServiceProvider(ServiceProvider())
        }

        val smartPhone = SmartPhone(
            Battery(),
            simCard,
            MemoryCard()
        )
        smartPhone.makeACallWithRecording()
    }
}