package com.example.hotelrating.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.hotelrating.feature.hotelinfo.model.Hotel

class MainViewModel:ViewModel() {
    val hotelLD = MutableLiveData<Hotel>()
}