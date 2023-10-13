package com.example.hotelrating.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hotelrating.feature.home.hotelinfo.model.Hotel
import com.example.hotelrating.repository.MainRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import org.koin.java.KoinJavaComponent.inject

class MainViewModel:ViewModel() {

    private val repository : MainRepository by inject(MainRepository::class.java)
//    fun signUp(user: User) {
//        viewModelScope.launch(Dispatchers.IO) {
//            repository.addUser(user)
//        }
//    }

    fun signUp(email:String,password:String) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.signIn(email,password)
        }
    }



    val hotelLD = MutableStateFlow<Hotel?>(null)
}