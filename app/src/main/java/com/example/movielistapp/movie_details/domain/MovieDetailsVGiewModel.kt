package com.example.movielistapp.movie_details.domain

import androidx.lifecycle.viewModelScope
import com.example.movielistapp.core.viewmodel.BaseViewModel
import com.example.movielistapp.core.viewmodel.BaseViewState
import com.example.movielistapp.movie_details.MovieDetailsEvent
import com.example.movielistapp.movie_details.MovieDetailsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailsVGiewModel @Inject constructor(private val repository: MovieDetailsRepository):
BaseViewModel<BaseViewState<MovieDetailsState>,MovieDetailsEvent>(){

    var data = MovieDetailsState()

    init {
        setState(BaseViewState.Loading)
    }

    override fun ontriggerEvent(eventType: MovieDetailsEvent) {
        when(eventType){
            is MovieDetailsEvent.ShowDetails ->{
                viewModelScope.launch {
                    val id = eventType.id
                    val result = repository.getMovieDetailsById(id).toMovieDetailsDto()
                    data = data.copy(movieData = result)
                    setState(BaseViewState.Data(data))
                }
            }
        }
    }

}