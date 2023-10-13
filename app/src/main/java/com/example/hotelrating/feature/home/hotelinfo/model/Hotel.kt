package com.example.hotelrating.feature.home.hotelinfo.model

import com.example.hotelrating.R

data class Hotel (
    var hotelId:Int = -1,
    var hotelName:String = "",
    var hotelImageUrl:String = "",
    var rating: Rating? = null,
    var hotelImageList: List<Int> = listOf(R.drawable.hotel_bg_background, R.drawable.ic_baseline_hotel_24)
)