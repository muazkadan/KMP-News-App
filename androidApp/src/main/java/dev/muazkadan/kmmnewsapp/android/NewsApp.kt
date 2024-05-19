package dev.muazkadan.kmmnewsapp.android

import android.app.Application
import dev.muazkadan.kmmnewsapp.android.di.viewModelModule
import dev.muazkadan.kmmnewsapp.di.appModule
import dev.muazkadan.kmmnewsapp.di.dataModule
import dev.muazkadan.kmmnewsapp.di.networkModule
import dev.muazkadan.kmmnewsapp.getDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module

class NewsApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@NewsApp)
            val dbModule = module {
                single {
                    getDatabase(this@NewsApp)
                }
            }
            modules(listOf(appModule(), networkModule(), dataModule(), viewModelModule(), dbModule))
        }
    }
}