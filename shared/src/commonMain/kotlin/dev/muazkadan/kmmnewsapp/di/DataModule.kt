package dev.muazkadan.kmmnewsapp.di

import dev.muazkadan.kmmnewsapp.data.repositroy.CategoryRepository
import dev.muazkadan.kmmnewsapp.data.repositroy.NewsRepository
import org.koin.dsl.module

fun dataModule() = module {
    single { CategoryRepository() }
    single { NewsRepository(get(), get()) }
}