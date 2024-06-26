package com.tttrfge.testprojectsession1.common

sealed class ResponseState<T> {
    class Success<T>(val data: T) : ResponseState<T>()
    class Error<T>(val message: String) : ResponseState<T>()
}