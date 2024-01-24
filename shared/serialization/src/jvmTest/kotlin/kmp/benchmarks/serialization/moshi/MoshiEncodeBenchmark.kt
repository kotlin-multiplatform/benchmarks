package kmp.benchmarks.serialization.moshi

import kmp.benchmarks.serialization.Resources
import kotlinx.benchmark.Benchmark
import kotlinx.benchmark.Scope
import kotlinx.benchmark.State

@State(Scope.Benchmark)
class MoshiEncodeBenchmark {
    @Benchmark
    fun encodeLargeListToString() {
        Moshi.encodeLargeListToString(Data.largeList)
    }

    @Benchmark
    fun encodeLargeListCompactToString() {
        Moshi.encodeLargeListCompactToString(Data.largeListCompact)
    }

    @Benchmark
    fun encodeMacOsReleasesToString() {
        Moshi.encodeMacOsReleasesToString(Data.macosReleases)
    }

    @Benchmark
    fun encodePolymorphicGeoToString() {
        Moshi.encodePolymorphicGeoToString(Data.polymorphicGeo)
    }

    @Benchmark
    fun encodePolymorphicHtmlToString() {
        Moshi.encodePolymorphicHtmlToString(Data.polymorphicHtml)
    }

    @Benchmark
    fun encodeUserProfileToString() {
        Moshi.encodeUserProfileToString(Data.userProfile)
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