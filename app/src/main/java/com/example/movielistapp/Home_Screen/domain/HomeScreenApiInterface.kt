package com.example.movielistapp.Home_Screen.domain

import com.example.movielistapp.Home_Screen.model2.PopularMoviesResponse
import com.example.movielistapp.Home_Screen.model2.TopRatedMoviesResponse2
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface HomeScreenApiInterface {
    @GET("movie/top_rated")
    suspend fun getTopRatedMovies(@Header("accept") host: String ="application/json",
                                  @Header("Authorization") key:String="Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIwYTJiMzlmNDJlOWFhYjQzZjk0OWMwMzZkYmUxODEwMSIsIm5iZiI6MTcyMDQzMDg3Mi4xNTY1NTUsInN1YiI6IjY2OGJhZmY0MDM0ZjQwZTFhNGIxZTJiOCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.xw4m40is-8Di2JMzFsZ3ZWKDMTX5lo4tAlSUYzS1CrI",
                                  @Query("language") rankingsChartType: String ="en-US",
                                  @Query("page") languageCountry: String ="1"):Response<TopRatedMoviesResponse2>

    @GET("movie/popular")
    suspend fun getPopularMovies(@Header("accept") host :String ="application/json",
                                 @Header("Authorization") key:String="Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIwYTJiMzlmNDJlOWFhYjQzZjk0OWMwMzZkYmUxODEwMSIsIm5iZiI6MTcyMDQzMDg3Mi4xNTY1NTUsInN1YiI6IjY2OGJhZmY0MDM0ZjQwZTFhNGIxZTJiOCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.xw4m40is-8Di2JMzFsZ3ZWKDMTX5lo4tAlSUYzS1CrI",
                                 @Query("language") rankingsChartType: String ="en-US",
                                 @Query("page") languageCountry: String ="1"):Response<PopularMoviesResponse>

}