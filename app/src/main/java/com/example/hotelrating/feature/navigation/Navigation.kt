package com.example.hotelrating.feature.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.hotelrating.feature.homescreen.view.HomeScreen
import com.example.hotelrating.feature.hotelinfo.HotelDetails
import com.example.hotelrating.feature.login.view.Login
import com.example.hotelrating.utils.Screen


@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController =navController, startDestination = Screen.LoginScreen.route ){
        composable(Screen.LoginScreen.route){
            Login(navController)
        }
        composable(Screen.HomeScreen.route){
            HomeScreen(navController)
        }
        composable(Screen.HotelDetailsScreen.route){
            HotelDetails()
        }
    }
}