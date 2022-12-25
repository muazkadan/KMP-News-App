package dev.muazkadan.kmmnewsapp

import dev.muazkadan.kmmnewsapp.data.repositroy.CategoryRepository
import dev.muazkadan.kmmnewsapp.data.repositroy.NewsRepository
import dev.muazkadan.kmmnewsapp.di.appModule
import dev.muazkadan.kmmnewsapp.di.dataModule
import dev.muazkadan.kmmnewsapp.di.networkModule
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin

class CategoryHelper : KoinComponent {
    private val categoryRepository: CategoryRepository by inject()
    suspend fun getCategories() = categoryRepository.getCategories()
}

class NewsHelper : KoinComponent {
    private val newsRepository: NewsRepository by inject()

    @Throws(Exception::class)
    suspend fun getNews(category: String) = newsRepository.getCategoryNews(category)
}

fun initKoin() {
    startKoin {
        modules(listOf(appModule(), networkModule(), dataModule()))
    }
}