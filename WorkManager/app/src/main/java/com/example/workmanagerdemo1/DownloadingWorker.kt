package com.example.workmanagerdemo1

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*

class DownloadingWorker(context: Context, params: WorkerParameters) : Worker(context, params) {

    override fun doWork(): Result {
        return try {
            for (i in 0 .. 3000) {
                Log.i("MyTag", "Downloading $i")
            }

            val time = SimpleDateFormat("dd/MM/yyyy hh:mm:ss")
            val currentDate = time.format(Date())
            Log.i("MyTag", "Completed $currentDate")

            Result.success()
        } catch (e: Exception) {
            Result.failure()
        }
    }
}