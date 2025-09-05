package com.rahulgoswami.mindfeed.viewmodels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rahulgoswami.mindfeed.models.TweetListItem
import com.rahulgoswami.mindfeed.repository.MindFeedRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TweetViewModel @Inject constructor(
    private val mindFeedRepository: MindFeedRepository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    // Expose tweets StateFlow from repository
    val tweets: StateFlow<List<TweetListItem>> = mindFeedRepository.tweets

    init {
        // Fetch tweets for the category from SavedStateHandle (default "Android")
        viewModelScope.launch {
            val category = savedStateHandle.get<String>("category") ?: "Android"
            mindFeedRepository.getTweets(category)
        }
    }
}
