package dev.muazkadan.kmmnewsapp.android.presentation.news

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.muazkadan.kmmnewsapp.data.model.NewsModel
import dev.muazkadan.kmmnewsapp.data.repositroy.NewsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class NewsViewModel constructor(
    private val repository: NewsRepository,
): ViewModel() {

    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState

    fun getNews(category: String){
        viewModelScope.launch {
            val response = repository.getCategoryNews(category)
            _uiState.update { uiState ->
                uiState.copy(
                    isLoading = false,
                    news = response
                )
            }
        }
    }

    data class UiState(
        val news: List<NewsModel> = emptyList(),
        val isLoading: Boolean = true
    )
}