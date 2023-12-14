package kmp.benchmarks.networking.ktorhttpclient

import io.ktor.client.engine.*
import io.ktor.client.engine.cio.*

actual fun httpClientEngine(): HttpClientEngine = CIO.create()