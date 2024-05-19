package dev.muazkadan.kmmnewsapp

import android.content.Context
import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import dev.muazkadan.kmmnewsapp.data.local.NewsDatabase
import kotlinx.coroutines.Dispatchers

fun getDatabase(ctx: Context): NewsDatabase {
    val appContext = ctx.applicationContext
    val dbFile = appContext.getDatabasePath("news_room.db")
    return Room.databaseBuilder<NewsDatabase>(
        context = appContext,
        name = dbFile.absolutePath
    ).setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(Dispatchers.IO)
        .build()
}