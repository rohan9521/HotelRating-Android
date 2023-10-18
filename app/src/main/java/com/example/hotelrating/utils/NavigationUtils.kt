package com.example.hotelrating.utils

sealed class Screen(val route:String) {
    object Auth:Screen(AUTH){
        object SignUpScreen: Screen(SIGN_UP_SCREEN)
        object LoginScreen : Screen(LOGIN_SCREEN)
    }
    object Home : Screen(HOME_SCREEN){
        object HotelFeed : Screen(HOTELS_FEED_SCREEN)
        object Profile : Screen(PROFILE_SCREEN)
        object HotelDetailsScreen: Screen(HOTEL_DETAILS_SCREEN)
        object Explore :Screen(EXPLORE_SCREEN)
    }

}