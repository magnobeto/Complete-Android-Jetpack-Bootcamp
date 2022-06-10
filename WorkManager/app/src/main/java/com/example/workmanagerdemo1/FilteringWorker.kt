package com.example.workmanagerdemo1

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.lang.Exception

class FilteringWorker(context: Context, params: WorkerParameters) : Worker(context, params) {

    override fun doWork(): Result {
        return try {
            for (i in 0 .. 300) {
                Log.i("MyTag", "Filtering $i")
            }
            Result.success()
        } catch (e: Exception) {
            Result.failure()
        }
    }
}