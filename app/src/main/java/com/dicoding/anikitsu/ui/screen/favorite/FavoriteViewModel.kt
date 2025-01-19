package com.dicoding.anikitsu.ui.screen.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dicoding.anikitsu.data.AnimeRepository
import com.dicoding.anikitsu.model.AnimeEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(private val repository: AnimeRepository) : ViewModel() {
    private val _favAnime: MutableStateFlow<List<AnimeEntity>> = MutableStateFlow(emptyList())
    val favAnime: StateFlow<List<AnimeEntity>> get() = _favAnime

    fun getListFavAnime(){
        viewModelScope.launch {
            val response = repository.getFavAnime()
            _favAnime.value = response
        }
    }

}