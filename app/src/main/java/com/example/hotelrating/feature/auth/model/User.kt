package com.example.hotelrating.feature.auth.model

import com.example.hotelrating.feature.home.hotelinfo.model.Rating

data class User(
    val id:String,
    var name:String,
    var email:String,
    var about:String,
    var password:String,
    var ratingList:List<Rating>
)