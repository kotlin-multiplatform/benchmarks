package kmp.benchmarks.networking.endpoints

import io.ktor.client.call.body
import io.ktor.client.request.get
import kmp.benchmarks.networking.ApiClient
import kmp.benchmarks.serialization.model.GithubPush

suspend fun ApiClient.largeList(): List<GithubPush> =
    httpClient
        .get("/kotlin-multiplatform/benchmarks/main/json-data/large-list.json")
        .body()