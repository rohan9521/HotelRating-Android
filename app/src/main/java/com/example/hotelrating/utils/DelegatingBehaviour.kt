package com.example.hotelrating.utils

import android.app.Activity
import android.os.Build
import android.view.View
import androidx.activity.ComponentActivity
import androidx.compose.ui.graphics.Color
import androidx.core.view.WindowCompat

class DelegatingBehaviour : TransparentTopBar{
    override fun makeTopBarTransparent(activity:ComponentActivity) {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
//            activity.window.statusBarColor = Color.Transparent
//        }else{
//            activity.window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
//        }

    }
}