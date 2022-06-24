package com.example.fcmtest2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkRequest
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val uploadWorkRequest: WorkRequest =
            PeriodicWorkRequestBuilder<UploadWorker>(15,TimeUnit.MINUTES)
                .build()

        WorkManager
            .getInstance(this)
            .enqueue(uploadWorkRequest)


    }


}