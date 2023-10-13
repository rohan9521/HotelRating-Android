package com.example.hotelrating.utils

sealed class Screen(val route:String) {
    object SignUpScreen: Screen(SIGN_UP_SCREEN)
    object LoginScreen : Screen(LOGIN_SCREEN)
    object HomeScreen : Screen(HOME_SCREEN)
    object HotelInfoScreen : Screen(HOTEL_INFO_SCREEN)
    object SettingsScreen : Screen(SETTINGS_SCREEN)
    object HotelDetailsScreen: Screen(HOTEL_DETAILS_SCREEN)
}