package dev.muazkadan.kmmnewsapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import dev.muazkadan.kmmnewsapp.data.local.entity.NewsEntity

@Database(
    entities = [NewsEntity::class],
    version = 1
)
abstract class NewsDatabase : RoomDatabase(), DB {

    abstract fun dao(): NewsDao

    override fun clearAllTables() {
        super.clearAllTables()
    }
}

// TODO: remove when fixed
interface DB {
    fun clearAllTables() {}
}