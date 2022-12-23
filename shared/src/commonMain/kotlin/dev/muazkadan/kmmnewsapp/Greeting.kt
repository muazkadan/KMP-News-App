package dev.muazkadan.kmmnewsapp

class Greeting {
    private val platform: Platform = getPlatform()

    fun greet(): String {
        return "Hello ny name ${platform.name}!"
    }
}