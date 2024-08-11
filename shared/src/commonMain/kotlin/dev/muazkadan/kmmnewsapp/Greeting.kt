package dev.muazkadan.kmmnewsapp

import org.koin.core.annotation.Single

@Single
class Greeting(private val platform: Platform) {

    fun greet(): String {
        return "Hello my name ${platform.name}!"
    }
}