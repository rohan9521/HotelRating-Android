package com.example.hotelrating

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.core.view.WindowCompat
import com.example.hotelrating.feature.navigation.Navigation
import com.example.hotelrating.ui.theme.HotelRatingTheme
import com.example.hotelrating.utils.DelegatingBehaviour
import com.example.hotelrating.utils.TransparentTopBar
import com.google.firebase.auth.FirebaseAuth

class MainActivity : ComponentActivity(), TransparentTopBar by DelegatingBehaviour() {

    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        makeTopBarTransparent(this)
        firebaseAuth = FirebaseAuth.getInstance()
        val contextComposition = compositionLocalOf { this }
        setContent {
            CompositionLocalProvider(contextComposition provides this) {
                HotelRatingTheme{
                    Navigation(this,firebaseAuth)
                }
            }

        }
    }
}