package kmp.benchmarks.networking.ktorhttpclient

import io.ktor.client.engine.*
import io.ktor.client.engine.darwin.*

actual fun httpClientEngine(): HttpClientEngine = Darwin.create()