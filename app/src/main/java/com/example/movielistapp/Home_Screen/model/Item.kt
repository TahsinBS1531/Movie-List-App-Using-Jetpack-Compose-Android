package com.example.movielistapp.Home_Screen.model

data class Item(
    val __typename: String,
    val canRate: CanRate,
    val id: String,
    val originalTitleText: OriginalTitleText,
    val primaryImage: PrimaryImage,
    val ratingsSummary: RatingsSummary,
    val releaseDate: ReleaseDate,
    val releaseYear: ReleaseYear,
    val titleText: TitleText,
    val titleType: TitleType
)