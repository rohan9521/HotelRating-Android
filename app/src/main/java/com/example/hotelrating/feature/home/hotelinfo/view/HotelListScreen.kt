package com.example.hotelrating.feature.home.hotelinfo.view


import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.hotelrating.feature.home.hotelinfo.model.Hotel
import com.example.hotelrating.feature.home.hotelinfo.model.Rating
import com.example.hotelrating.ui.theme.Typography
import com.example.hotelrating.utils.Screen
import com.example.hotelrating.viewmodel.MainViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel


@Composable
fun HotelListScreen(
    mainNavHostController: NavHostController,
    mainViewModel: MainViewModel = koinViewModel()
) {
    val scope = rememberCoroutineScope()
    hotelInfoListView(navHostController = mainNavHostController, mainViewModel = mainViewModel, scope = scope)
}

@Composable
fun hotelInfoListView(
    hotelInfoList: MutableList<Hotel> = mutableListOf(
        Hotel(
            hotelName = "Vivanta",
            rating = Rating(
                "",
                "",
                "",
                2,
                ""
            )
        ),
        Hotel(
            hotelName = "Vivanta",
            rating = Rating(
                "",
                "",
                "",
                2,
                ""
            )
        ),
        Hotel(
            hotelName = "Vivanta",
            rating = Rating(
                "",
                "",
                "",
                2,
                ""
            )
        ),
        Hotel(
            hotelName = "Vivanta",
            rating = Rating(
                "",
                "",
                "",
                2,
                ""
            )
        ),
        Hotel(
            hotelName = "Vivanta",
            rating = Rating(
                "",
                "",
                "",
                2,
                ""
            )
        ),
        Hotel(
            hotelName = "Vivanta",
            rating = Rating(
                "",
                "",
                "",
                2,
                ""
            )
        ),
        Hotel(
            hotelName = "Vivanta",
            rating = Rating(
                "",
                "",
                "",
                2,
                ""
            )
        ),
        Hotel(
            hotelName = "Vivanta",
            rating = Rating(
                "",
                "",
                "",
                2,
                ""
            )
        ),
    ), navHostController: NavHostController,
    mainViewModel: MainViewModel,
    scope:CoroutineScope
) {
    LazyColumn {
        items(hotelInfoList) { hotel ->
            hotelItemView(hotel) { hotel ->
                scope.launch(Dispatchers.IO) {
                    mainViewModel.hotelLD.emit(hotel)
                }
                navHostController.navigate(Screen.Home.HotelDetailsScreen.route)

            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
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
        val state = rememberPagerState()
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.height(300.dp),
        ) {

                HorizontalPager(
                    pageCount = 2,
                    state = state,
                    modifier = Modifier.weight(1f),
                    key = { hotel.hotelImageList[it] }
                ) { index ->
                    Image(
                        painter = painterResource(id = hotel.hotelImageList[index]),
                        contentDescription = "swipe image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(1f)
                    )
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Text(text = hotel.hotelName,
                        modifier = Modifier
                            .fillMaxWidth(.2f),
                        color = Color.Green
                        , style = Typography.bodyLarge)
                    Text(text = if(hotel.rating != null)hotel.rating?.rating.toString() else "")
                }




        }
    }

}
