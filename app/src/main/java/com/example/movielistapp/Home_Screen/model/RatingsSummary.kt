package com.example.movielistapp.Home_Screen.model

data class RatingsSummary(
    val aggregateRating: Double,
    val topRanking: TopRanking,
    val voteCount: Int
)