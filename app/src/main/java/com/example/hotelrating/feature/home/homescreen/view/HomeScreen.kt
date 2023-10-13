package com.example.hotelrating.feature.home.homescreen.view

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.hotelrating.R
import com.example.hotelrating.feature.home.homescreen.BottomNavItem
import com.example.hotelrating.utils.Screen

@Composable
@Preview
fun HomeScreen(mainNavHostController: NavHostController = rememberNavController()) {
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
    val compositionNavController = compositionLocalOf { homeScreenNavHostController }
    Scaffold(
        bottomBar = {
            BottomView( bottomNavItemList = list ,homeScreenNavHostController)
        }
    ) {
        CompositionLocalProvider(compositionNavController provides homeScreenNavHostController ) {

        }

    }
}
