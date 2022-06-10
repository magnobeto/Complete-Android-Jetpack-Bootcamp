package com.example.workmanagerdemo1

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.lang.Exception

class DownloadingWorker(context: Context, params: WorkerParameters) : Worker(context, params) {

    override fun doWork(): Result {
        return try {
            for (i in 0 .. 3000) {
                Log.i("MyTag", "Downloading $i")
            }
            Result.success()
        } catch (e: Exception) {
            Result.failure()
        }
    }
}