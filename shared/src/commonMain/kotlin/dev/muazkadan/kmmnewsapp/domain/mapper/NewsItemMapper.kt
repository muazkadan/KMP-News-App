package dev.muazkadan.kmmnewsapp.domain.mapper

import dev.muazkadan.kmmnewsapp.data.local.entity.NewsEntity
import dev.muazkadan.kmmnewsapp.data.model.NewsModel


class NewsItemMapper {

    fun map(input: NewsEntity): NewsModel {
        return NewsModel(
            author = input.author,
            content = input.content,
            date = input.date,
            imageUrl = input.imageUrl,
            readMoreUrl = input.readMoreUrl.orEmpty(),
            time = input.time,
            title = input.title,
            url = input.url
        )
    }

    fun map(input: NewsModel, category: String): NewsEntity {
        return NewsEntity(
            author = input.author,
            content = input.content,
            date = input.date,
            imageUrl = input.imageUrl,
            readMoreUrl = input.readMoreUrl.orEmpty(),
            time = input.time,
            title = input.title,
            url = input.url,
            category = category
        )
    }
}
