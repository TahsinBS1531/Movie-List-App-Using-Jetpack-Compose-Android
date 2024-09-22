package com.example.movielistapp.Home_Screen.domain

import androidx.lifecycle.viewModelScope
import com.example.movielistapp.Home_Screen.HomeScreenEvent
import com.example.movielistapp.Home_Screen.HomeScreenViewState
import com.example.movielistapp.core.viewmodel.BaseViewModel
import com.example.movielistapp.core.viewmodel.BaseViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(val repository : HomeScreenRepository)
    : BaseViewModel<BaseViewState<HomeScreenViewState>, HomeScreenEvent>() {

    private var _data = HomeScreenViewState()
    init {
        setState(BaseViewState.Data(_data))
    }

    override fun ontriggerEvent(eventType: HomeScreenEvent) {
        when (eventType) {
            is HomeScreenEvent.LoadTopRatedMovies -> loadTopRatedData()
            HomeScreenEvent.LoadtPopularMovies -> loadPopularMovies()
            HomeScreenEvent.SaveOfflineData -> saveOfflineMovies()
        }
    }


    private fun loadTopRatedData() {
        viewModelScope.launch {
            try {
                startLoading()
                val movies = repository.getTopRatedMovies().map {
                    it.toMovieDto()
                }
                _data = _data.copy(topRatedModel = movies)
                setState(BaseViewState.Data(_data))
            } catch (e: Exception) {
                handleError(e)
            }
        }
    }

    private fun loadPopularMovies(){
        viewModelScope.launch {
            try {
                startLoading()
                val movies = repository.getPopularMovies().map {
                    it.toMovieDto()
                }
                _data = _data.copy(popularMovieModel = movies)
                setState(BaseViewState.Data(_data))
            }catch (e:Exception){
                handleError(e)
            }
        }
    }

    private fun saveOfflineMovies(){
        viewModelScope.launch {
            try {
                repository.appSync()
            }catch (e:Exception){
                handleError(e)
            }
        }
    }




}