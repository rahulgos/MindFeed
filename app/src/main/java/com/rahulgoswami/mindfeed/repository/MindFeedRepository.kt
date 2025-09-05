package com.rahulgoswami.mindfeed.repository

import com.rahulgoswami.mindfeed.api.MindFeedAPI
import com.rahulgoswami.mindfeed.models.TweetListItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class MindFeedRepository @Inject constructor(
    private val mindFeedAPI: MindFeedAPI
) {

    // StateFlow holding the list of categories
    private val _categories = MutableStateFlow<List<String>>(emptyList())
    val categories: StateFlow<List<String>> = _categories

    // StateFlow holding the list of tweets
    private val _tweets = MutableStateFlow<List<TweetListItem>>(emptyList())
    val tweets: StateFlow<List<TweetListItem>> = _tweets

    // Fetch categories from API and emit to StateFlow
    suspend fun getCategories() {
        val response = mindFeedAPI.getCategories()
        if (response.isSuccessful && response.body() != null) {
            _categories.emit(response.body()!!)
        }
    }

    // Fetch tweets for a specific category and emit to StateFlow
    suspend fun getTweets(category: String) {
        val response = mindFeedAPI.getTweets("tweets[?(@.category==\"$category\")]")
        if (response.isSuccessful && response.body() != null) {
            _tweets.emit(response.body()!!)
        }
    }
}
