package com.example.hotelrating.di

import com.example.hotelrating.viewmodel.MainViewModel
import org.koin.dsl.module

val module = module {
    single<MainViewModel>{MainViewModel()}
}