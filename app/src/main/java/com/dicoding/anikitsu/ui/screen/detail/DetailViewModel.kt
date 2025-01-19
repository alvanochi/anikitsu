package com.dicoding.anikitsu.ui.screen.detail

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dicoding.anikitsu.data.AnimeRepository
import com.dicoding.anikitsu.model.AnimeEntity
import com.dicoding.anikitsu.model.DataItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class DetailViewModel @Inject constructor(private val repository: AnimeRepository) : ViewModel() {
    private val _anime: MutableStateFlow<DataItem?> = MutableStateFlow(null)
    val anime: StateFlow<DataItem?> get() = _anime

    private val _isLoading = MutableStateFlow<Boolean>(true)
    val isLoading: StateFlow<Boolean> get() = _isLoading

    private val _isFavAnime = MutableStateFlow<AnimeEntity?>(null)
    val isFavAnime: StateFlow<AnimeEntity?> get() = _isFavAnime

    fun getAnimeById(id: String) {
        viewModelScope.launch {
            try {
                val response = repository.getAnimeById(id)
                _anime.value = response.data
                _isLoading.value = false
            } catch (e: Exception) {
                Log.e("getAnimeById", e.message.toString())
            }
        }
    }

    fun saveAnime(anime: List<AnimeEntity>) {
        viewModelScope.launch {
            repository.saveAnime(anime)
            isAnimeFavorite(anime.first().id)
        }
    }

    fun deleteAnime(animeId: String) {
        viewModelScope.launch {
            repository.deleteAnime(animeId)
            isAnimeFavorite(animeId)
        }
    }

    fun isAnimeFavorite(animeId: String) {
        viewModelScope.launch {
            val response = repository.isAnimeFavorite(animeId)
            _isFavAnime.value = response
        }
    }
}
