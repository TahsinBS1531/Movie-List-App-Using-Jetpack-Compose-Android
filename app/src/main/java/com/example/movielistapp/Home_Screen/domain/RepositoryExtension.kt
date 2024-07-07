package com.example.movielistapp.Home_Screen.domain

import retrofit2.Response

inline fun <reified T, R> Response<T>.mapSuccess(
    crossinline block: (T) -> R
): R {
    val safeBody = body()
    if (this.isSuccessful && safeBody != null) {
        return block(safeBody)
    }
    else if(this.isSuccessful && this.code() == 204){
        return block(T::class.java.newInstance())
    }

    else {
        throw toException()
    }
}

fun <T> Response<T>.toException():java.lang.Exception{
    return Exception("Network call failed with code ${code()} and message: ${message()}")
}