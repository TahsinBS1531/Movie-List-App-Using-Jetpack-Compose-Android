package com.example.movielistapp.Home_Screen.model

data class TitleType(
    val __typename: String,
    val canHaveEpisodes: Boolean,
    val categories: List<Category>,
    val displayableProperty: DisplayablePropertyX,
    val id: String,
    val isEpisode: Boolean,
    val isSeries: Boolean,
    val text: String
)