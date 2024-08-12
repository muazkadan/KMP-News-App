package dev.muazkadan.kmmnewsapp.android

import android.app.Application
import dev.muazkadan.kmmnewsapp.android.di.viewModelModule
import dev.muazkadan.kmmnewsapp.di.AppModule
import dev.muazkadan.kmmnewsapp.di.DataModule
import dev.muazkadan.kmmnewsapp.di.NetworkModule
import dev.muazkadan.kmmnewsapp.getDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module
import org.koin.ksp.generated.module

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
            modules(
                listOf(
                    AppModule().module,
                    NetworkModule().module,
                    DataModule().module,
                    viewModelModule(),
                    dbModule
                )
            )
        }
    }
}