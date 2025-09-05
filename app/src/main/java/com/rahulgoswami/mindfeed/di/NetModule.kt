package com.rahulgoswami.mindfeed.di

import com.rahulgoswami.mindfeed.api.MindFeedAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetModule {

    // Provides a singleton Retrofit instance
    @Singleton
    @Provides
    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.jsonbin.io")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    // Provides MindFeedAPI implementation
    @Singleton
    @Provides
    fun providesMindFeedAPI(retrofit: Retrofit): MindFeedAPI {
        return retrofit.create(MindFeedAPI::class.java)
    }
}
