package kmp.benchmarks.networking.ktorhttpclient

import io.ktor.client.engine.*
import io.ktor.client.engine.okhttp.OkHttp

actual fun httpClientEngine(): HttpClientEngine = OkHttp.create()