package com.example.hotelrating.di

import com.example.hotelrating.feature.network.NetworkApi
import com.example.hotelrating.utils.BASE_URL
import com.example.hotelrating.viewmodel.MainViewModel
import okhttp3.CacheControl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val module = module {
    single<MainViewModel>{MainViewModel()}
    single<HttpLoggingInterceptor>{HttpLoggingInterceptor()}
    single {
        val cacheControl = CacheControl
            .Builder()

        OkHttpClient
        .Builder()
        .addInterceptor(get<HttpLoggingInterceptor>())
    }
    single<Retrofit>{
        Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get<OkHttpClient>())
            .build()
    }
    single<NetworkApi>{
        val retrofit = get<Retrofit>()
        retrofit.create(NetworkApi::class.java)
    }


}