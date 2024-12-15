package kmp.benchmarks.networking.ktor.endpoints

import io.ktor.client.call.body
import io.ktor.client.request.get
import kmp.benchmarks.networking.ktor.KtorApiClient
import kmp.benchmarks.serialization.model.kotlinxserialization.GeoJSONObject

suspend fun KtorApiClient.polymorphicGeo(): List<GeoJSONObject> =
    httpClient
        .get("/kotlin-multiplatform/benchmarks/main/json-data/polymorphic-geo.json")
        .body()