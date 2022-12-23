package dev.muazkadan.kmmnewsapp.di

import dev.muazkadan.kmmnewsapp.Greeting
import dev.muazkadan.kmmnewsapp.Platform
import org.koin.dsl.module

fun appModule() = module {
    single { Platform() }
    single { Greeting(get()) }
}