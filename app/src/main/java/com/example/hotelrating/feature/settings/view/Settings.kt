package com.example.hotelrating.feature.settings.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.hotelrating.R


@Composable
fun Settings(navController: NavController,mainNavHostController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {


        Box(
            modifier = Modifier
                .background(Brush.horizontalGradient(listOf(Color.White, Color.Green)))
                .fillMaxWidth()
                .fillMaxHeight(.2f)
                .align(Alignment.CenterHorizontally),
            contentAlignment = Alignment.BottomCenter
        ) {
            Image(
                painterResource(R.drawable.hotel_bg_background),
                contentDescription = "user badge",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(CircleShape)
            )
        }

        Text("My Ratings")

    }
}