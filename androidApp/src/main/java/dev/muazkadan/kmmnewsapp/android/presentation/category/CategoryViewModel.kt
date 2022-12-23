package dev.muazkadan.kmmnewsapp.android.presentation.category

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.muazkadan.kmmnewsapp.data.model.CategoryModel
import dev.muazkadan.kmmnewsapp.data.repositroy.CategoryRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CategoryViewModel(private val repository: CategoryRepository) : ViewModel() {

    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getCategories().collectLatest {
                _uiState.update { _uiState ->
                    _uiState.copy(
                        categories = it
                    )
                }
            }
        }
    }

    data class UiState(
        val categories: List<CategoryModel> = emptyList(),
    )
}