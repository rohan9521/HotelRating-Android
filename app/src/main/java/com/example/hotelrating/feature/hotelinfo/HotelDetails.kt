package com.example.hotelrating.feature.hotelinfo

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.hotelrating.R
import com.example.hotelrating.feature.hotelinfo.model.Hotel
import com.example.hotelrating.viewmodel.MainViewModel
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HotelDetails(mainViewModel:MainViewModel = koinViewModel()) {
    val state = rememberPagerState()
    val list = listOf(R.drawable.hotel_bg_background, R.drawable.ic_baseline_hotel_24)
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        HorizontalPager(
            pageCount = 2,
            state = state,
            key = { list[it] }
        ) { index ->
            Image(painter = painterResource(id = list[index]),
                contentDescription = "swipe image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(.2f))
        }
        mainViewModel.hotelLD.value?.let { Text(text = it.hotelName) }
    }
}