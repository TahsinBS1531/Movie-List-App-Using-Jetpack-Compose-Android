package com.example.movielistapp.core.di

import com.example.movielistapp.Home_Screen.domain.HomeScreenApiInterface
import com.example.movielistapp.Home_Screen.domain.HomeScreenRepository
import com.example.movielistapp.core.db.MovieDao
import com.example.movielistapp.movie_details.domain.MovieDetailsApiInterface
import com.example.movielistapp.movie_details.domain.MovieDetailsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object RepositoryModule {

    @Provides
    @Singleton
    fun provideHomeRepository(api :HomeScreenApiInterface,movieDao: MovieDao):HomeScreenRepository{
        return HomeScreenRepository(api,movieDao)
    }

    @Provides
    @Singleton
    fun ProvidesMovieDetailsRepository(api:MovieDetailsApiInterface):MovieDetailsRepository{
        return MovieDetailsRepository(api)
    }
}