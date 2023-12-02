package kmp.benchmarks.networking.endpoints

import io.ktor.client.call.body
import io.ktor.client.request.get
import kmp.benchmarks.networking.ApiClient
import kmp.benchmarks.serialization.model.MacOsReleases

suspend fun ApiClient.macOsReleases(): MacOsReleases =
    httpClient
        .get("/kotlin-multiplatform/benchmarks/main/json-data/macos-releases.json")
        .body()