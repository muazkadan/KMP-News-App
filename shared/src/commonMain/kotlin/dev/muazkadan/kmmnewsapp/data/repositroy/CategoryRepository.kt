package dev.muazkadan.kmmnewsapp.data.repositroy

import dev.muazkadan.kmmnewsapp.data.model.CategoryModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CategoryRepository {
    fun getCategories(): Flow<List<CategoryModel>> = flow {
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
        emit(categories)
    }
}