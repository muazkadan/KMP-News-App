package dev.muazkadan.kmmnewsapp.di

import io.ktor.client.*
import io.ktor.client.plugins.cache.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.plugins.observer.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import org.koin.core.annotation.KoinInternalApi
import org.koin.dsl.module

@OptIn(KoinInternalApi::class)
fun networkModule() = module {
    single {
        HttpClient {
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
    }
}