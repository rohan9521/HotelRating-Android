package com.example.hotelrating.feature.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.hotelrating.feature.home.homescreen.view.Explore
import com.example.hotelrating.feature.home.homescreen.view.HotelFeed
import com.example.hotelrating.feature.home.homescreen.view.Profile
import com.example.hotelrating.feature.home.hotelinfo.view.HotelDetails
import com.example.hotelrating.utils.Screen

@Composable
fun HomeScreenNavigation(
    navHostController: NavHostController
) {
    NavHost(navController = navHostController, startDestination = Screen.Home.HotelFeed.route) {
        composable(route = Screen.Home.HotelFeed.route) {
            HotelFeed(navHostController)
        }
        composable(route = Screen.Home.Explore.route) {
            Explore()
        }
        composable(route = Screen.Home.Profile.route) {
            Profile()
        }
        composable(route= Screen.Home.HotelDetailsScreen.route){
            HotelDetails()
        }
    }
}