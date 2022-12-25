package dev.muazkadan.kmmnewsapp.data.repositroy

import dev.muazkadan.kmmnewsapp.data.model.NewsModel
import dev.muazkadan.kmmnewsapp.data.model.NewsResponseModel
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class NewsRepository constructor(
    private var httpClient: HttpClient
) {

    suspend fun getCategoryNews(category: String): List<NewsModel> {
        return httpClient.get(urlString = "https://inshorts.deta.dev/news?category=$category")
            .body<NewsResponseModel>().data
    }
}