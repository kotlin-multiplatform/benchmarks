package kmp.benchmarks.serialization.gson

import kmp.benchmarks.serialization.Resources
import kotlinx.benchmark.Benchmark
import kotlinx.benchmark.Scope
import kotlinx.benchmark.State

@State(Scope.Benchmark)
class GsonEncodeBenchmark {
    @Benchmark
    fun encodeLargeListToString() {
        Gson.encodeLargeListToString(Data.largeList)
    }

    @Benchmark
    fun encodeLargeListCompactToString() {
        Gson.encodeLargeListCompactToString(Data.largeListCompact)
    }

    @Benchmark
    fun encodeMacOsReleasesToString() {
        Gson.encodeMacOsReleasesToString(Data.macosReleases)
    }

    @Benchmark
    fun encodePolymorphicGeoToString() {
        Gson.encodePolymorphicGeoToString(Data.polymorphicGeo)
    }

    @Benchmark
    fun encodePolymorphicHtmlToString() {
        Gson.encodePolymorphicHtmlToString(Data.polymorphicHtml)
    }

    @Benchmark
    fun encodeUserProfileToString() {
        Gson.encodeUserProfileToString(Data.userProfile)
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