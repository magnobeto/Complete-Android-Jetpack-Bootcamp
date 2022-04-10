package com.example.coroutinesdemo2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.coroutinesdemo1.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private suspend fun getStock1(): Int {
        delay(10000)
        Log.i("Mytag", "stock 1 returned")
        return 55000
    }

    private suspend fun getStock2(): Int {
        delay(8000)
        Log.i("Mytag", "stock 2 returned")
        return 35000
    }
}