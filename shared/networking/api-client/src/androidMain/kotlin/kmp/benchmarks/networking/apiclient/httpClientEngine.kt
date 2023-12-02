package kmp.benchmarks.networking.apiclient

import io.ktor.client.engine.*
import io.ktor.client.engine.okhttp.OkHttp

actual fun httpClientEngine(): HttpClientEngine = OkHttp.create()