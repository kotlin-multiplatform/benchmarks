package kmp.benchmarks.networking.ktor

import io.ktor.client.HttpClientConfig
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.plugins.BrowserUserAgent
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.http.ContentType
import io.ktor.http.Url
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kmp.common.ktor.KtorHttpClient
import kmp.common.ktor.httpClientEngine

class ApiClient(
    baseUrl: Url = Url("https://raw.githubusercontent.com"),
    engine: HttpClientEngine = httpClientEngine(),
) : KtorHttpClient(engine) {

    override val configureHttpClient: HttpClientConfig<*>.() -> Unit = {
        install(ContentNegotiation) {
            json()
        }

        Logging {
            level = LogLevel.INFO
        }

        BrowserUserAgent()

        defaultRequest {
            host = baseUrl.host
            contentType(ContentType.Application.Json)
            url {
                protocol = baseUrl.protocol
            }
        }
    }
}