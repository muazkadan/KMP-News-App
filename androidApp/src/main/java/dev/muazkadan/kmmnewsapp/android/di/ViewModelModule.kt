package dev.muazkadan.kmmnewsapp.android.di

import dev.muazkadan.kmmnewsapp.android.presentation.category.CategoryViewModel
import dev.muazkadan.kmmnewsapp.android.presentation.news.NewsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

fun viewModelModule() = module {
    viewModel { CategoryViewModel(get()) }
    viewModel { NewsViewModel(get()) }
}