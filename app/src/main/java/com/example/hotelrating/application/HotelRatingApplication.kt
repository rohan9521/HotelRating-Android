package com.example.hotelrating.application

import android.app.Application
import com.example.hotelrating.di.module
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class HotelRatingApplication:Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidContext(this@HotelRatingApplication)
            androidLogger()
            modules(module)
        }
    }
}