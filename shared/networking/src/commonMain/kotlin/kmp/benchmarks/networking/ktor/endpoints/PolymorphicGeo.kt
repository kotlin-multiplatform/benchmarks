package kmp.benchmarks.networking.ktor.endpoints

import io.ktor.client.call.body
import io.ktor.client.request.get
import kmp.benchmarks.networking.ktor.ApiClient
import kmp.benchmarks.serialization.model.kotlinxserialization.GeoJSONObject

suspend fun ApiClient.polymorphicGeo(): List<GeoJSONObject> =
    httpClient
        .get("/kotlin-multiplatform/benchmarks/main/json-data/polymorphic-geo.json")
        .body()