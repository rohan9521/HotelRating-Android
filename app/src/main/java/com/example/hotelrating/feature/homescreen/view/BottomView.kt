package com.example.hotelrating.feature.homescreen.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.hotelrating.R
import com.example.hotelrating.feature.homescreen.BottomNavItem
import com.example.hotelrating.utils.Screen


@Composable
fun BottomView(bottomNavItemList:List<BottomNavItem>,navHostController: NavHostController) {
    val backStackEntry = navHostController.currentBackStackEntryAsState()
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(Color.Black),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        bottomNavItemList.forEach{item->
            item.isSelected = backStackEntry?.value?.destination?.route == item.route
            Image(painterResource(id =item.icon),"BottomNavItem", modifier = Modifier
                .height(20.dp)
                .width(20.dp)
                .clickable {
                    if(!item.isSelected)
                        navHostController.navigate(item.route)
                })
        }
    }
}