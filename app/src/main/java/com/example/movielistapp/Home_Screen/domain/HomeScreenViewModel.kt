package com.example.movielistapp.Home_Screen.domain

import androidx.lifecycle.viewModelScope
import com.example.movielistapp.Home_Screen.HomeScreenEvent
import com.example.movielistapp.Home_Screen.HomeScreenViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(val repository : HomeScreenRepository)
    :BaseViewModel<BaseViewState<HomeScreenViewState>,HomeScreenEvent>() {

    private var _data = HomeScreenViewState()
    val data: HomeScreenViewState get() = _data

    override fun ontriggerEvent(eventType: HomeScreenEvent) {
        when (eventType) {
            is HomeScreenEvent.LoadTopRatedMovies -> {
                loadTopRatedData()
            }
        }
    }


    private fun loadTopRatedData() {
        viewModelScope.launch {
            try {
                startLoading()
                val movies = repository.getTopRatedMovies()
                _data = _data.copy(topRatedModel = movies)
                setState(BaseViewState.Data(_data))
            } catch (e: Exception) {
                handleError(e)
            }
        }
    }



}