package kmp.benchmarks.serialization.gson

import kotlinx.benchmark.Benchmark
import kotlinx.benchmark.Scope
import kotlinx.benchmark.State

@State(Scope.Benchmark)
class GsonEncodeBenchmark {
    @Benchmark
    fun encodeLargeListToString() {
        Gson.encodeLargeListToString(JsonData.largeList)
    }

    @Benchmark
    fun encodeLargeListCompactToString() {
        Gson.encodeLargeListCompactToString(JsonData.largeListCompact)
    }

    @Benchmark
    fun encodeMacOsReleasesToString() {
        Gson.encodeMacOsReleasesToString(JsonData.macosReleases)
    }

    @Benchmark
    fun encodePolymorphicGeoToString() {
        Gson.encodePolymorphicGeoToString(JsonData.polymorphicGeo)
    }

    @Benchmark
    fun encodePolymorphicHtmlToString() {
        Gson.encodePolymorphicHtmlToString(JsonData.polymorphicHtml)
    }

    @Benchmark
    fun encodeUserProfileToString() {
        Gson.encodeUserProfileToString(JsonData.userProfile)
    }

//    @Benchmark
//    fun combined() {
//        Gson.encodeLargeListToString(Data.largeList)
//        Gson.encodeLargeListCompactToString(Data.largeListCompact)
//        Gson.encodeMacOsReleasesToString(Data.macosReleases)
//        Gson.encodePolymorphicGeoToString(Data.polymorphicGeo)
//        Gson.encodePolymorphicHtmlToString(Data.polymorphicHtml)
//        Gson.encodeUserProfileToString(Data.userProfile)
//    }
}