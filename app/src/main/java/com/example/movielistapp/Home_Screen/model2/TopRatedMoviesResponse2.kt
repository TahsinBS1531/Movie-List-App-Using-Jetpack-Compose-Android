package com.example.movielistapp.Home_Screen.model2

data class TopRatedMoviesResponse2(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)