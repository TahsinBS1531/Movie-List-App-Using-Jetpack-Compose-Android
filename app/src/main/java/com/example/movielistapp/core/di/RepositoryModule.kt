package com.example.movielistapp.core.di

import com.example.movielistapp.Home_Screen.domain.HomeScreenApiInterface
import com.example.movielistapp.Home_Screen.domain.HomeScreenRepository
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
    fun provideHomeRepository(api :HomeScreenApiInterface):HomeScreenRepository{
        return HomeScreenRepository(api)
    }
}