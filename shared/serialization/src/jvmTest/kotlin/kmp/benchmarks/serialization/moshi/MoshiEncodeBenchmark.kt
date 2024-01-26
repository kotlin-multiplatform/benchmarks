package kmp.benchmarks.serialization.moshi

import kotlinx.benchmark.Benchmark
import kotlinx.benchmark.Scope
import kotlinx.benchmark.State

@State(Scope.Benchmark)
class MoshiEncodeBenchmark {
    @Benchmark
    fun encodeLargeListToString() {
        Moshi.encodeLargeListToString(JsonData.largeList)
    }

    @Benchmark
    fun encodeLargeListCompactToString() {
        Moshi.encodeLargeListCompactToString(JsonData.largeListCompact)
    }

    @Benchmark
    fun encodeMacOsReleasesToString() {
        Moshi.encodeMacOsReleasesToString(JsonData.macosReleases)
    }

    @Benchmark
    fun encodePolymorphicGeoToString() {
        Moshi.encodePolymorphicGeoToString(JsonData.polymorphicGeo)
    }

    @Benchmark
    fun encodePolymorphicHtmlToString() {
        Moshi.encodePolymorphicHtmlToString(JsonData.polymorphicHtml)
    }

    @Benchmark
    fun encodeUserProfileToString() {
        Moshi.encodeUserProfileToString(JsonData.userProfile)
    }

//    @Benchmark
//    fun combined() {
//        Moshi.encodeLargeListToString(Data.largeList)
//        Moshi.encodeLargeListCompactToString(Data.largeListCompact)
//        Moshi.encodeMacOsReleasesToString(Data.macosReleases)
//        Moshi.encodePolymorphicGeoToString(Data.polymorphicGeo)
//        Moshi.encodePolymorphicHtmlToString(Data.polymorphicHtml)
//        Moshi.encodeUserProfileToString(Data.userProfile)
//    }
}