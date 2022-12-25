package dev.muazkadan.kmmnewsapp.data.model

import kotlinx.serialization.Serializable

@Serializable
data class NewsResponseModel(
    val category: String,
    val `data`: List<NewsModel>,
    val error: String? = null,
    val success: Boolean
)

@Serializable
data class NewsModel(
    val author: String,
    val content: String,
    val date: String,
    val imageUrl: String,
    val readMoreUrl: String?,
    val time: String,
    val title: String,
    val url: String
)
