package com.example.hotelrating.repository

import com.example.hotelrating.feature.home.hotelinfo.model.Hotel
import com.example.hotelrating.feature.auth.model.User
import com.example.hotelrating.feature.network.NetworkApi
import com.example.hotelrating.utils.ResponseUtil
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainRepository(
    val networkApi:NetworkApi
) {
    private val TAG = "MainRepository"
    private var firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()

    private var signUpMutableStateFlow = MutableStateFlow<ResponseUtil<User>>(ResponseUtil.Default<User>())
    var signUpStateFlow:StateFlow<ResponseUtil<User>> = signUpMutableStateFlow.asStateFlow()

    private var loginMutableStateFlow = MutableStateFlow<ResponseUtil<User>>(ResponseUtil.Default<User>())
    var loginUpStateFlow:StateFlow<ResponseUtil<User>> = signUpMutableStateFlow.asStateFlow()

    private var hotelMutableStateFlow = MutableStateFlow<ResponseUtil<List<Hotel>>>(ResponseUtil.Default<List<Hotel>>())
    var hotelStateFlow:StateFlow<ResponseUtil<User>> = signUpMutableStateFlow.asStateFlow()

//    suspend fun addUser(email:String,password:String){
//
//
//        try{
//           val user =  firebaseAuth.createUserWithEmailAndPassword(email,password)
//            loginMutableStateFlow.value = ResponseUtil.Success<User>(data = user)
//        }catch (e:Exception){
//            loginMutableStateFlow.value = ResponseUtil.Error<User>(e.message.toString(),2)
//        }
//    }
    suspend fun signIn(email:String,password:String){
        try{
            val user =  networkApi.loginUser(email,password)
            signUpMutableStateFlow.value = ResponseUtil.Success(data = user)
        }catch (e:Exception){
            signUpMutableStateFlow.value = ResponseUtil.Error(e.message.toString(),2)
        }
    }

    suspend fun getAllHotels(){
        try{
            val listOfHotels =  networkApi.getAllHotels()
            hotelMutableStateFlow.value = ResponseUtil.Success<List<Hotel>>(data = listOfHotels)
        }catch (e:Exception){
            loginMutableStateFlow.value = ResponseUtil.Error(e.message.toString(),2)
        }
    }
}