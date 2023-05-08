package com.example.hotelrating.feature.login.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.hotelrating.feature.navigation.Navigation
import com.example.hotelrating.ui.theme.HotelRatingTheme
import com.example.hotelrating.utils.DelegatingBehaviour
import com.example.hotelrating.utils.TransparentTopBar

class MainActivity : ComponentActivity(), TransparentTopBar by DelegatingBehaviour() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        makeTopBarTransparent(this)

        setContent {

            HotelRatingTheme{

               Navigation()
            }
        }
    }
}