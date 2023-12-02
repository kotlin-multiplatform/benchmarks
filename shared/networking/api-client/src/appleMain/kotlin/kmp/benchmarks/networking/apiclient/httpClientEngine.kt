package kmp.benchmarks.networking.apiclient

import io.ktor.client.engine.*
import io.ktor.client.engine.darwin.*

actual fun httpClientEngine(): HttpClientEngine = Darwin.create()