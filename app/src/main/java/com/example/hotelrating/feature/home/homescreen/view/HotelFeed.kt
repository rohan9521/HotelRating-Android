package com.example.hotelrating.feature.home.homescreen.view

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.hotelrating.feature.home.hotelinfo.view.HotelListScreen

@Composable
fun HotelFeed(navHostController: NavHostController) {
    HotelListScreen(navHostController)
}