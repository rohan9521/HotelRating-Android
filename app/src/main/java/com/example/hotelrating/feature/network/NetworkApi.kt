package com.example.hotelrating.feature.network

import com.example.hotelrating.feature.home.hotelinfo.model.Hotel
import com.example.hotelrating.feature.home.hotelinfo.model.Rating
import com.example.hotelrating.feature.auth.model.User
import retrofit2.http.GET
import retrofit2.http.POST

interface NetworkApi {
    @POST
    fun addUser(user: User): User

    @GET
    fun loginUser(email:String,password:String): User

    @GET
    fun getAllHotels():List<Hotel>

    fun getAllRatingOfHotel(hotelId:String):List<Rating>

    fun addRating(hotelId:String,rating: Rating)

}