package dev.muazkadan.kmmnewsapp.data.repositroy

import dev.muazkadan.kmmnewsapp.data.model.CategoryModel
import kotlinx.coroutines.delay

class CategoryRepository {
    suspend fun getCategories(): List<CategoryModel> {
        val categories = listOf(
            CategoryModel("All", "all"),
            CategoryModel("National", "national"),
            CategoryModel("Business", "business"),
            CategoryModel("Sports", "sports"),
            CategoryModel("World", "world"),
            CategoryModel("Politics", "politics"),
            CategoryModel("Technology", "technology"),
            CategoryModel("Startup", "startup"),
            CategoryModel("Entertainment", "entertainment"),
            CategoryModel("Miscellaneous", "miscellaneous"),
            CategoryModel("Hatke", "hatke"),
            CategoryModel("Science", "science"),
            CategoryModel("Automobile", "automobile")
        )
        delay(2000)
        return categories
    }
}