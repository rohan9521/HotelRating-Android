package com.example.hotelrating.feature.homescreen.view

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.hotelrating.R
import com.example.hotelrating.feature.homescreen.BottomNavItem
import com.example.hotelrating.feature.homescreen.navigation.HomeScreenNavigation
import com.example.hotelrating.utils.Screen

@Composable
fun HomeScreen(mainNavHostController: NavHostController) {
    val list = listOf(
        BottomNavItem(
            Screen.HotelInfoScreen.route,
            R.drawable.baseline_home_24
        ),
        BottomNavItem(
            Screen.SettingsScreen.route,
            R.drawable.baseline_settings_24
        )
    )
    val homeScreenNavHostController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomView( bottomNavItemList = list ,homeScreenNavHostController)
        }
    ) {
        HomeScreenNavigation(mainNavHostController, homeScreenNavHostController)
    }
}
