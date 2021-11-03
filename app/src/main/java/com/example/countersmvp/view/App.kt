package com.example.countersmvp.view

import android.app.Application

class App : Application() {
    companion object {
        lateinit var instace: App
    }

    override fun onCreate() {
        super.onCreate()
        instace = this
    }
}