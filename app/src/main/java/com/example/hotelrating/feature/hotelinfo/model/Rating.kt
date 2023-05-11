package com.example.hotelrating.feature.hotelinfo.model

data class Rating(
    val ratingId: String,
    val userId: String,
    val hotelId: String,
    val rating: Int,
    val feedback: String
)