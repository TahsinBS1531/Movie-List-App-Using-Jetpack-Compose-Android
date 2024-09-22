package com.example.movielistapp.movie_details.domain

import com.example.movielistapp.movie_details.model.MovieDetailsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieDetailsApiInterface {

    @GET("movie/{movie_id}")
    suspend fun getMovieDetails(
        @Header("accept") host: String ="application/json",
        @Header("Authorization") key:String="Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIwYTJiMzlmNDJlOWFhYjQzZjk0OWMwMzZkYmUxODEwMSIsIm5iZiI6MTcyMDQzMDg3Mi4xNTY1NTUsInN1YiI6IjY2OGJhZmY0MDM0ZjQwZTFhNGIxZTJiOCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.xw4m40is-8Di2JMzFsZ3ZWKDMTX5lo4tAlSUYzS1CrI",
        @Path("movie_id") movieId: Int,
        @Query("language") language: String = "en-US"
    ): Response<MovieDetailsResponse>
}