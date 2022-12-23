package dev.muazkadan.kmmnewsapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform