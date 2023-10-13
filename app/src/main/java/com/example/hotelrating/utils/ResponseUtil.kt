package com.example.hotelrating.utils

sealed class ResponseUtil<T>(val data:T? = null, val errorMessage:String = "", val errorCode:Int = -1) {
    class Success<T>( data:T?=null):ResponseUtil<T>(data)
    class Error<T>(errorMessage: String,errorCode: Int):ResponseUtil<T>(errorMessage = errorMessage, errorCode = errorCode)
    class Default<T>:ResponseUtil<T>()
}