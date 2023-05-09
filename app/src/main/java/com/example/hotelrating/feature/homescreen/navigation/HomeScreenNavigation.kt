package com.example.hotelrating.feature.homescreen.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.hotelrating.feature.homescreen.view.HomeScreen
import com.example.hotelrating.feature.hotelinfo.view.HotelListScreen
import com.example.hotelrating.feature.settings.view.Settings

import com.example.hotelrating.utils.Screen


@Composable
fun HomeScreenNavigation(navHostController: NavHostController){

        NavHost(navController = navHostController, startDestination = Screen.HotelInfoScreen.route){
                composable(Screen.HotelInfoScreen.route){
                        HotelListScreen(navController = navHostController)
                }
                composable(Screen.SettingsScreen.route){
                        Settings(navController = navHostController)
                }
        }

}