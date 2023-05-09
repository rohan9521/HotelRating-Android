package com.example.hotelrating.feature.homescreen.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.hotelrating.R
import com.example.hotelrating.feature.homescreen.BottomNavItem

@Composable
fun BottomView(bottomNavItemList:List<BottomNavItem>) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        bottomNavItemList.forEach{item->
            Icon(painterResource(id =item.icon),"BottomNavItem", modifier = Modifier
                .padding(5.dp)
                .clickable {
                item.clickListener()
                })
        }
    }
}