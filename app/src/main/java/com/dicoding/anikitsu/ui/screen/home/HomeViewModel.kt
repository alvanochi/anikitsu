package com.dicoding.anikitsu.ui.screen.home

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dicoding.anikitsu.data.AnimeRepository
import com.dicoding.anikitsu.model.DataItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: AnimeRepository) : ViewModel() {
    private val _ongoingAnime: MutableStateFlow<List<DataItem>> = MutableStateFlow(emptyList())
    val ongoingAnime: StateFlow<List<DataItem>> get() = _ongoingAnime

    private val _finishedAnime: MutableStateFlow<List<DataItem>> = MutableStateFlow(emptyList())
    val finishedAnime: StateFlow<List<DataItem>> get() = _finishedAnime

    private val _queryAnime: MutableStateFlow<List<DataItem>> = MutableStateFlow(emptyList())
    val queryAnime: StateFlow<List<DataItem>> get() = _queryAnime
    private val _query = mutableStateOf("")
    val query: State<String> get() = _query

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> get() = _error

    private val _isLoading = MutableStateFlow<Boolean>(true)
    val isLoading: StateFlow<Boolean> get() = _isLoading

    fun getListOngoingAnime() {
        viewModelScope.launch {
            try {
                val response = repository.getListOngoingAnime()
                _ongoingAnime.value = response.data?.filterNotNull().orEmpty()

                _isLoading.value = false
            } catch (e: Exception) {
                Log.e("getListOngoingAnime", e.message.toString())
                _error.value = e.message
            }
        }
    }

    fun getListFinishedAnime() {
        viewModelScope.launch {
            try {
                val response = repository.getListFinishedAnime()
                _finishedAnime.value = response.data?.filterNotNull().orEmpty()

                _isLoading.value = false
            } catch (e: Exception) {
                Log.e("getListFinishedAnime", e.message.toString() )
                _error.value = e.message
            }
        }
    }

    fun getListQueryAnime(query: String) {
        _query.value = query
        _isLoading.value = true
        viewModelScope.launch {
            try {
                val response = repository.getListQueryAnime(query)
                _queryAnime.value = response.data?.filterNotNull().orEmpty()

                _isLoading.value = false
            } catch (e: Exception) {
                _isLoading.value = false
                Log.e("getListQueryAnime", e.message.toString() )
                _error.value = e.message
            }
        }
    }
}