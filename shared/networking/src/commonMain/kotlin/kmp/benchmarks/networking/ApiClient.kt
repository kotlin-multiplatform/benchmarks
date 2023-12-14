package kmp.benchmarks.networking

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
import kmp.benchmarks.networking.ktorhttpclient.KtorHttpClient
import kmp.benchmarks.networking.ktorhttpclient.httpClientEngine

class ApiClient(
    engine: HttpClientEngine = httpClientEngine(),
) : KtorHttpClient(engine) {

    private val baseUrl = Url("https://raw.githubusercontent.com/kotlin-multiplatform/benchmarks/main/json-data/user-profile.json")

    override val setupHttpClient: HttpClientConfig<*>.() -> Unit = {
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