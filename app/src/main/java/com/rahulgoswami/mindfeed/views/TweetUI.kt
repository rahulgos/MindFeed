package com.rahulgoswami.mindfeed.views

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.rahulgoswami.mindfeed.viewmodels.TweetViewModel

@Composable
fun TweetScreen() {
    val tweetViewModel: TweetViewModel = hiltViewModel()
    val tweets = tweetViewModel.tweets.collectAsState()

    if (tweets.value.isEmpty()) {
        // Show loading text while tweets are being fetched
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Loading...", style = MaterialTheme.typography.bodyLarge)
        }
    } else {
        // Display list of tweets
        LazyColumn {
            items(tweets.value) { tweetItem ->
                TweetListItem(tweet = tweetItem.text)
            }
        }
    }
}

@Composable
fun TweetListItem(tweet: String) {
    // Card representing a single tweet
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        border = BorderStroke(1.dp, Color(0xFFCCCCCC))
    ) {
        Text(
            text = tweet,
            modifier = Modifier.padding(16.dp),
            style = MaterialTheme.typography.bodyMedium
        )
    }
}
