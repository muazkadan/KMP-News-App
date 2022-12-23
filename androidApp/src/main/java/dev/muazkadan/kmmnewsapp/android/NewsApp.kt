package dev.muazkadan.kmmnewsapp.android

import android.app.Application
import dev.muazkadan.kmmnewsapp.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class NewsApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@NewsApp)
            modules(listOf(appModule()))
        }
    }
}