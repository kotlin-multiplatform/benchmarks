package kmp.benchmarks.networking.ktor.endpoints

import io.ktor.client.call.body
import io.ktor.client.request.get
import kmp.benchmarks.networking.ktor.KtorApiClient
import kmp.benchmarks.serialization.model.kotlinxserialization.GithubPush

suspend fun KtorApiClient.largeList(): List<GithubPush.Normal> =
    httpClient
        .get("/kotlin-multiplatform/benchmarks/main/json-data/large-list.json")
        .body()