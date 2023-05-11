package com.example.hotelrating.feature.hotelinfo.view


import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.hotelrating.R
import com.example.hotelrating.feature.hotelinfo.model.Hotel
import com.example.hotelrating.utils.Screen
import com.example.hotelrating.viewmodel.MainViewModel
import org.koin.androidx.compose.koinViewModel


@Composable
fun HotelListScreen(
    navHostController: NavHostController,
    mainNavHostController: NavHostController,
    mainViewModel: MainViewModel = koinViewModel()
) {
    hotelInfoListView(navHostController = mainNavHostController, mainViewModel = mainViewModel)
}

@Composable
fun hotelInfoListView(
    hotelInfoList: MutableList<Hotel> = mutableListOf(
        Hotel(hotelName = "Vivanta"),
        Hotel(hotelName = "Vivanta"),
        Hotel(hotelName = "Vivanta"),
        Hotel(hotelName = "Vivanta"),
        Hotel(hotelName = "Vivanta"),
        Hotel(hotelName = "Vivanta"),
        Hotel(hotelName = "Vivanta"),
        Hotel(hotelName = "Vivanta"),
        Hotel(hotelName = "Vivanta")
    ), navHostController: NavHostController,
    mainViewModel: MainViewModel
) {
    LazyColumn {
        items(hotelInfoList) { hotel ->
            hotelItemView(hotel) { hotel ->
                mainViewModel.hotelLD.value = hotel
                navHostController.navigate(Screen.HotelDetailsScreen.route)

            }
        }
    }
}

@Composable
fun hotelItemView(hotel: Hotel, clickListener: (Hotel) -> Unit) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .border(border = BorderStroke(5.dp, Color.Transparent), shape = RectangleShape)
        .padding(5.dp)
        .clickable {
            clickListener(hotel)
        }
    ) {

        Column(
            horizontalAlignment = Alignment.Start,
        ) {
            Image(
                painter = painterResource(
                    id = R.mipmap.hotel_bg_foreground
                ),
                contentScale = ContentScale.FillBounds,
                contentDescription = "Hotel View",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )

            Text(text = hotel.hotelName)
            Text(text = "Hotel Taj")


        }
    }

}
