package com.example.movielistapp.core.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.movielistapp.Home_Screen.data.MovieCardEntity
import com.example.movielistapp.Home_Screen.model.TopRatedMoviesResponse2


@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun saveMovieCard(movies:MovieCardEntity)

    @Query("SELECT * FROM movie_card")
    suspend fun getOfflineMovies():List<MovieCardEntity>
}