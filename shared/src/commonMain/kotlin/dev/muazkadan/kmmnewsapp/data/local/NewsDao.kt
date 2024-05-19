package dev.muazkadan.kmmnewsapp.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import dev.muazkadan.kmmnewsapp.data.local.entity.NewsEntity

@Dao
interface NewsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNews(items: List<NewsEntity>)

    @Delete
    suspend fun deleteNews(items: List<NewsEntity>)

    @Query("SELECT * FROM NewsEntity WHERE category IN (:newsCategory)")
    suspend fun getNews(newsCategory: String): List<NewsEntity>
}
