package dev.muazkadan.kmmnewsapp.data.repositroy

import dev.muazkadan.kmmnewsapp.data.local.NewsDatabase
import dev.muazkadan.kmmnewsapp.data.model.NewsModel
import dev.muazkadan.kmmnewsapp.data.model.NewsResponseModel
import dev.muazkadan.kmmnewsapp.domain.mapper.NewsItemMapper
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import org.koin.core.annotation.Single

@Single
class NewsRepository constructor(
    private var httpClient: HttpClient,
    private var database: NewsDatabase
) {

    suspend fun getCategoryNews(category: String): List<NewsModel> {
        return try {
            val response = httpClient.get(urlString = "https://inshortsapi.vercel.app/news?category=${category.lowercase()}")
                .body<NewsResponseModel>()
            val dao = database.dao()
            val mapper = NewsItemMapper()
            if(response.success){
                dao.deleteNews(dao.getNews(category))
                dao.insertNews(
                    response.data.map {
                        mapper.map(it, category)
                    }
                )
            }

            val newLocalNews = dao.getNews(category).map { mapper.map(it) }
            newLocalNews
        } catch (e: Exception) {
            val dao = database.dao()
            val newLocalNews = dao.getNews(category).map { NewsItemMapper().map(it) }
            newLocalNews
        }
    }
}