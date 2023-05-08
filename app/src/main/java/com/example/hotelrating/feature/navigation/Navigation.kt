package com.example.hotelrating.feature.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.hotelrating.feature.hotelinfo.view.HotelListScreen
import com.example.hotelrating.feature.login.view.Login


@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController =navController, startDestination = "loginOrHome" ){
        composable("loginOrHome"){
            Login(navController)
        }
        composable("homeScreen"){
            HotelListScreen(navController)
        }
    }
}