package com.example.hotelrating.feature.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.example.hotelrating.MainActivity
import com.example.hotelrating.feature.home.homescreen.view.HomeScreen
import com.example.hotelrating.feature.auth.login.Login
import com.example.hotelrating.feature.auth.main.AuthMainView
import com.example.hotelrating.feature.auth.signup.view.SignUp
import com.example.hotelrating.feature.home.hotelinfo.view.HotelDetails
import com.example.hotelrating.utils.Screen
import com.google.firebase.auth.FirebaseAuth

val LocalCompOfNavController = compositionLocalOf<NavController?> { null }
@Composable
fun Navigation(mainActivity: MainActivity , firebaseAuth: FirebaseAuth){
    val navController = rememberNavController()

    CompositionLocalProvider(LocalCompOfNavController provides navController) {
        NavHost(navController =navController, startDestination = Screen.Auth.route ){
            composable(Screen.Auth.route){
               AuthMainView(firebaseAuth = firebaseAuth,mainActivity)
            }
            navigation(startDestination = Screen.HomeScreen.route, route="home" ){
                composable(Screen.HomeScreen.route){
                    HomeScreen()
                }
                composable(Screen.HotelDetailsScreen.route){
                    HotelDetails()
                }
            }


        }
    }

}