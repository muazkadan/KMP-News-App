package dev.muazkadan.kmmnewsapp.network

import io.ktor.client.HttpClient
import io.ktor.client.plugins.cache.HttpCache
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.observer.ResponseObserver
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.annotation.KoinInternalApi
import org.koin.core.annotation.Single
import org.koin.mp.KoinPlatform.getKoin

@OptIn(KoinInternalApi::class)
@Single
fun getHttpClient() = HttpClient {
    expectSuccess = true
    install(Logging) {
        logger = object : Logger {
            override fun log(message: String) {
                getKoin().logger.debug("Logger Ktor => $message")
            }
        }
        level = LogLevel.ALL
    }
    install(ContentNegotiation) {
        json(
            Json {
                ignoreUnknownKeys = true
            }
        )
    }
    install(ResponseObserver) {
        onResponse { response ->
            getKoin().logger.debug("HTTP status: ${response.status.value}")
        }
    }
    install(HttpCache)
}