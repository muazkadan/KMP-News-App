package dev.muazkadan.kmmnewsapp

import org.koin.core.annotation.Single

@Single
expect class Platform() {
    val name: String
}
