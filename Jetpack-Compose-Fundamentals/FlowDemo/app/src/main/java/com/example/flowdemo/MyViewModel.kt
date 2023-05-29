package com.example.flowdemo

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class MyViewModel : ViewModel() {

    val myFlow = flow<Int> {
        for (i in 1..100) {
            emit(i)
            delay(1000L)
        }
    }

    init {
        backPressureDemo()
    }

    private fun backPressureDemo() {
        val myflow1 = flow<Int> {
            for (i in 1..10) {
                Log.i("MYTAG", "Produced $i")
                emit(i)
                delay(1000L)
            }
        }

        // Only Produce again when a previous value has been consumed, cause gap time
        viewModelScope.launch {
            myflow1
                .filter { count ->
                    count % 3 == 0
                }
                .map {
                    transformIntoString(it)
                }
                .collect {
                    delay(2000L)
                    Log.i("MYTAG", "Consumed $it")
                }
        }

        // Alow to buffer values produced, to be consume on the time by consumer
//        viewModelScope.launch {
//            myflow1.buffer().collect {
//                delay(2000L)
//                Log.i("MYTAG", "Consumed $it")
//            }
//        }

        // Consume only latest value produced
//        viewModelScope.launch {
//            myflow1.collectLatest {
//                delay(2000L)
//                Log.i("MYTAG", "Consumed $it")
//            }
//        }
    }

    private fun transformIntoString(value: Int) = "Hello $value"
}