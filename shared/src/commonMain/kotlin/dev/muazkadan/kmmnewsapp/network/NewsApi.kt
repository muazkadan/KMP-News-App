package dev.muazkadan.kmmnewsapp.network

import dev.muazkadan.kmmnewsapp.data.model.NewsResponseModel

interface NewsApi {
    suspend fun getCategoryNews(category: String): NewsResponseModel
}
