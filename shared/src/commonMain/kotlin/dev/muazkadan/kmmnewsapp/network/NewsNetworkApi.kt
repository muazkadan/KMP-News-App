package dev.muazkadan.kmmnewsapp.network

import dev.muazkadan.kmmnewsapp.data.model.NewsResponseModel
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import org.koin.core.annotation.Single

@Single
class NewsNetworkApi(private val httpClient: HttpClient) : NewsApi {
    override suspend fun getCategoryNews(category: String): NewsResponseModel {
        val url = "https://inshortsapi.vercel.app/news?category=${category.lowercase()}"
        return try {
            httpClient.get(url).body()
        } catch (e: Exception) {
            e.printStackTrace()
            NewsResponseModel("", emptyList(), e.message, false)
        }
    }
}
