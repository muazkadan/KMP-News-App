package dev.muazkadan.kmmnewsapp

import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import dev.muazkadan.kmmnewsapp.data.local.NewsDatabase
import dev.muazkadan.kmmnewsapp.data.local.instantiateImpl
import dev.muazkadan.kmmnewsapp.data.repositroy.CategoryRepository
import dev.muazkadan.kmmnewsapp.data.repositroy.NewsRepository
import dev.muazkadan.kmmnewsapp.di.AppModule
import dev.muazkadan.kmmnewsapp.di.DataModule
import dev.muazkadan.kmmnewsapp.di.networkModule
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin
import org.koin.dsl.module
import platform.Foundation.NSHomeDirectory
import org.koin.ksp.generated.module

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
        val dbModule = module {
            single<NewsDatabase> {
                val dbFilePath = NSHomeDirectory() + "/news_room.db"
                Room.databaseBuilder<NewsDatabase>(
                    name = dbFilePath,
                    factory = { NewsDatabase::class.instantiateImpl() }
                ).setDriver(BundledSQLiteDriver())
                    .setQueryCoroutineContext(Dispatchers.IO)
                    .build()
            }
        }
        modules(listOf(AppModule().module, networkModule(), DataModule().module, dbModule))

    }
}