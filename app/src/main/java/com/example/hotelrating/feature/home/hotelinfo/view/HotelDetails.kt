package com.example.hotelrating.feature.home.hotelinfo.view

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.hotelrating.R
import com.example.hotelrating.feature.home.hotelinfo.model.Hotel
import com.example.hotelrating.viewmodel.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HotelDetails(mainViewModel: MainViewModel = koinViewModel()) {
    val state = rememberPagerState()
    val scope = rememberCoroutineScope()
    val hotel = remember{ mutableStateOf<Hotel?>(null) }
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
            Image(
                painter = painterResource(id = list[index]),
                contentDescription = "swipe image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(.4f)
            )
        }
        LaunchedEffect(key1 = true){
            scope.launch(Dispatchers.IO) {
                mainViewModel.hotelLD.collect{
                    hotel.value = it
                }
            }
        }

        hotel?.value?.hotelName?.let { Text(text = it) }
    }

}