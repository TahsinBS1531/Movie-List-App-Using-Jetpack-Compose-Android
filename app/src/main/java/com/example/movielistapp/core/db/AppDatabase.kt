package com.example.movielistapp.core.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.movielistapp.Home_Screen.data.MovieCardEntity


@Database(entities = [MovieCardEntity::class], version = 2, exportSchema = false)

abstract class AppDatabase:RoomDatabase(){
    abstract fun getDao():MovieDao
}