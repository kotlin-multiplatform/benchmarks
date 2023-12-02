package kmp.benchmarks.networking.endpoints

import io.ktor.client.call.body
import io.ktor.client.request.get
import kmp.benchmarks.networking.ApiClient
import kmp.benchmarks.serialization.model.HtmlChunk

suspend fun ApiClient.polymorphicHtml(): List<HtmlChunk> =
    httpClient
        .get("/kotlin-multiplatform/benchmarks/main/json-data/polymorphic-html.json")
        .body()