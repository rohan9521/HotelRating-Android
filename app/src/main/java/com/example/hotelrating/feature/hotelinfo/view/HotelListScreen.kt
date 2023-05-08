package com.example.hotelrating.feature.hotelinfo.view


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.hotelrating.R
import com.example.hotelrating.feature.hotelinfo.model.Hotel


@Composable
fun HotelListScreen(navController: NavController) {
    hotelInfoListView()
}
    @Preview
    @Composable
    fun hotelInfoListView(hotelInfoList:MutableList<Hotel> = mutableListOf(
        Hotel(hotelName = "Vivanta"),
        Hotel(hotelName = "Vivanta"),
        Hotel(hotelName = "Vivanta"),
        Hotel(hotelName = "Vivanta"),
        Hotel(hotelName = "Vivanta"),
        Hotel(hotelName = "Vivanta"),
        Hotel(hotelName = "Vivanta"),
        Hotel(hotelName = "Vivanta"),
        Hotel(hotelName = "Vivanta")
    )){
        LazyColumn {
            items(hotelInfoList){
                hotel-> hotelItemView(hotelName = hotel.hotelName, hotelImageId = R.mipmap.ic_launcher_foreground )
            }
        }
    }

    @Composable
    fun hotelItemView(hotelName:String, hotelImageId:Int){
        Card(modifier = Modifier
            .fillMaxWidth()
            .border(border = BorderStroke(5.dp, Color.Transparent), shape = RectangleShape)
            .padding(5.dp)
        ) {

            Column(
                horizontalAlignment = Alignment.Start,
                modifier = Modifier.padding(horizontal =  5.dp)
            ) {
                Image(
                    painter = painterResource(
                        id = hotelImageId
                    ),
                    contentScale = ContentScale.FillBounds,
                    contentDescription = "Hotel View",
                    modifier = Modifier
                        .fillMaxSize()
                )

                    Text(text = hotelName)
                    Text(text = "Hotel Taj")


            }
        }

    }
