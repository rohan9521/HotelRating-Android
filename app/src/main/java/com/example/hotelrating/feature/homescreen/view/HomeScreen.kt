package com.example.hotelrating.feature.homescreen.view


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
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
    Scaffold(
        bottomBar = {
            BottomView( bottomNavItemList = list ,mainNavHostController)
        }
    ) {
        HomeScreenNavigation(mainNavHostController)
    }
}
