package com.example.movielistapp.movie_details.model

data class MovieDetailsResponse(
    val adult: Boolean,
    val backdrop_path: String,
    val belongs_to_collection: Any,
    val budget: Int,
    val genres: List<Genre>,
    val homepage: String,
    val id: Int,
    val imdb_id: String,
    val origin_country: List<String>,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val production_companies: List<ProductionCompany>,
    val production_countries: List<ProductionCountry>,
    val release_date: String,
    val revenue: Int,
    val runtime: Int,
    val spoken_languages: List<SpokenLanguage>,
    val status: String,
    val tagline: String,
    val title: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Int
){
    fun toMovieDetailsDto():MovieDetailsDto{
        return MovieDetailsDto(
            id = id,
            title = title,
            overview = overview,
            vote = vote_average,
            release_date = release_date,
            poster_path = poster_path,
            genres = genres.map {
                it.name
            }
        )
    }

}

data class MovieDetailsDto(
    var id:Int,
    var title: String,
    var overview: String,
    var vote:Double,
    var release_date: String,
    var poster_path: String,
    var genres:List<String>
)