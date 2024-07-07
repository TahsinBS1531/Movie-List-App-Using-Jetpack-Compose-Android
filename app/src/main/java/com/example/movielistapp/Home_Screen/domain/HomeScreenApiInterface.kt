package com.example.movielistapp.Home_Screen.domain

import com.example.movielistapp.Home_Screen.model.TopRatedResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface HomeScreenApiInterface {
    @GET("api/imdb/title-chart-rankings/v1?rankingsChartType=TOP_250&languageCountry=en_US")
    suspend fun getTopRatedMovies(@Header("x-rapidapi-host") host: String,
                                  @Header("x-rapidapi-key") key:String,
                                  @Query("rankingsChartType") rankingsChartType: String ="TOP_250",
                                  @Query("languageCountry") languageCountry: String ="en_US"):Response<TopRatedResponse>

}