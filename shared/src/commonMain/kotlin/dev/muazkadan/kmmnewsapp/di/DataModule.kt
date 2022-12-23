package dev.muazkadan.kmmnewsapp.di

import dev.muazkadan.kmmnewsapp.data.repositroy.CategoryRepository
import org.koin.dsl.module

fun dataModule() = module {
    single { CategoryRepository() }
}