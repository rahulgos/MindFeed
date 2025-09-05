package com.rahulgoswami.mindfeed.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rahulgoswami.mindfeed.repository.MindFeedRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(
    private val mindFeedRepository: MindFeedRepository
) : ViewModel() {

    // Expose categories StateFlow from repository
    val categories: StateFlow<List<String>> = mindFeedRepository.categories

    init {
        // Fetch categories when ViewModel is created
        viewModelScope.launch {
            mindFeedRepository.getCategories()
        }
    }
}
