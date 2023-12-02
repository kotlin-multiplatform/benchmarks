package kmp.benchmarks.networking.apiclient

import io.ktor.client.*
import io.ktor.client.engine.*
import io.ktor.utils.io.core.*

abstract class ApiClient(
    private val engine: HttpClientEngine = httpClientEngine()
) : Closeable {

    private var _httpClient: HttpClient? = null
    val httpClient: HttpClient
        get() {
            if (_httpClient == null) {
                _httpClient = HttpClient(engine, setupHttpClient)
            }

            return _httpClient!!
        }

    override fun close() {
        _httpClient?.close()
        _httpClient = null
    }

    abstract val setupHttpClient: HttpClientConfig<*>.() -> Unit
}