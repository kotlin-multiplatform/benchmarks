package kmp.benchmarks.networking.ktor.endpoints

import io.ktor.client.call.body
import io.ktor.client.request.get
import kmp.benchmarks.networking.ktor.KtorApiClient
import kmp.benchmarks.serialization.model.kotlinxserialization.HtmlChunk

suspend fun KtorApiClient.polymorphicHtml(): List<HtmlChunk> =
    httpClient
        .get("/kotlin-multiplatform/benchmarks/main/json-data/polymorphic-html.json")
        .body()