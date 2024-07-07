package com.example.movielistapp.Home_Screen.di

import com.example.movielistapp.Home_Screen.domain.HomeScreenApiInterface
import com.example.movielistapp.Home_Screen.domain.HomeScreenRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {

    @Provides
    @Singleton
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://imdb231.p.rapidapi.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun getTopRatedApi(api:Retrofit):HomeScreenApiInterface{
        return api.create(HomeScreenApiInterface::class.java)
    }




}