package dev.muazkadan.kmmnewsapp

import dev.muazkadan.kmmnewsapp.data.repositroy.CategoryRepository
import dev.muazkadan.kmmnewsapp.di.appModule
import dev.muazkadan.kmmnewsapp.di.dataModule
import dev.muazkadan.kmmnewsapp.di.networkModule
import kotlinx.coroutines.flow.first
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin

class CategoryHelper : KoinComponent {
    private val categoryRepository: CategoryRepository by inject()
    suspend fun getCategories() = categoryRepository.getCategories().first()
}

fun initKoin() {
    startKoin {
        modules(listOf(appModule(), networkModule(), dataModule()))
    }
}