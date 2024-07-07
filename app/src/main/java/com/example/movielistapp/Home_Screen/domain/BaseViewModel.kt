package com.example.movielistapp.Home_Screen.domain

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel<State:BaseViewState<*>,Event> :ViewModel(){

    private val _uiState =MutableStateFlow<BaseViewState<*>>(BaseViewState.Empty)
    val uiState = _uiState.asStateFlow()

    abstract fun ontriggerEvent(eventType:Event)

    protected fun setState(state:State){
        viewModelScope.launch {
            _uiState.emit(state)
        }
    }

    fun startLoading(){
        _uiState.value = BaseViewState.Loading
    }

    fun handleError(exception:Throwable){
        _uiState.value = BaseViewState.Error(exception)
    }



}