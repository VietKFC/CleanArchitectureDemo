package com.example.presentations

import android.app.Application

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }
}
