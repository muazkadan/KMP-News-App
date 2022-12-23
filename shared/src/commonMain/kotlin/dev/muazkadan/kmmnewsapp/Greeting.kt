package dev.muazkadan.kmmnewsapp

class Greeting(private val platform: Platform) {

    fun greet(): String {
        return "Hello my name ${platform.name}!"
    }
}