package com.rahulgoswami.mindfeed.api

import com.rahulgoswami.mindfeed.models.TweetListItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface MindFeedAPI {

    // Fetch tweets based on category
    @GET("/v3/b/68b9709643b1c97be93670c4?meta=false")
    suspend fun getTweets(@Header("X-JSON-Path") category: String): Response<List<TweetListItem>>

    // Fetch available tweet categories
    @GET("/v3/b/68b9709643b1c97be93670c4?meta=false")
    @Headers("X-JSON-Path: tweets..category")
    suspend fun getCategories(): Response<List<String>>
}
