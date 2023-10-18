package com.example.hotelrating.feature.home.homescreen.view

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.hotelrating.R
import com.example.hotelrating.feature.home.homescreen.BottomNavItem
import com.example.hotelrating.feature.navigation.HomeScreenNavigation
import com.example.hotelrating.feature.navigation.LocalCompOfNavController
import com.example.hotelrating.utils.Screen

@Composable
fun HomeScreen() {

    val list = listOf(
        BottomNavItem(
            Screen.Home.HotelFeed.route,
            R.drawable.baseline_home_24
        ),
        BottomNavItem(
            Screen.Home.Explore.route,
            R.drawable.ic_outline_explore_24
        ),
        BottomNavItem(
            Screen.Home.Profile.route,
            R.drawable.ic_baseline_person_24
        )
    )
    val navHostController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomView(bottomNavItemList = list, navHostController)
        }
    ) {
        HomeScreenNavigation(navHostController)
    }

}
