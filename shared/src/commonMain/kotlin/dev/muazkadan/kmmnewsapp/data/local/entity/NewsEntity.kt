package dev.muazkadan.kmmnewsapp.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class NewsEntity(
    val author: String,
    val content: String,
    val date: String,
    val imageUrl: String,
    val readMoreUrl: String?,
    val time: String,
    val title: String,
    val url: String,
    val category: String,
    @PrimaryKey val id: Int? = null
)
