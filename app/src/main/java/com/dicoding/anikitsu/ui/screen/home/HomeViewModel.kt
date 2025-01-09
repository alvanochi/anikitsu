package com.dicoding.anikitsu.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dicoding.anikitsu.data.AnimeRepository
import com.dicoding.anikitsu.model.Anime
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: AnimeRepository) : ViewModel() {
    private val _ongoingAnime: MutableStateFlow<List<Anime>> = MutableStateFlow(emptyList())
    val ongoingAnime: StateFlow<List<Anime>> get() = _ongoingAnime

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> get() = _error

    fun getListOngoingAnime() {
        viewModelScope.launch {
            try {
                val response = repository.getListOngoingAnime()
                _ongoingAnime.value = response
            } catch (e: Exception) {
                _error.value = e.message
            }
        }
    }
}