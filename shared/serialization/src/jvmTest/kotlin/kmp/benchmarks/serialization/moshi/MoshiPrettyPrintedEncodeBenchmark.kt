package kmp.benchmarks.serialization.moshi

import kotlinx.benchmark.Benchmark
import kotlinx.benchmark.Scope
import kotlinx.benchmark.State

@State(Scope.Benchmark)
class MoshiPrettyPrintedEncodeBenchmark {
    @Benchmark
    fun encodeLargeListToString() {
        MoshiPrettyPrinted.encodeLargeListToString(JsonData.largeList)
    }

    @Benchmark
    fun encodeLargeListCompactToString() {
        MoshiPrettyPrinted.encodeLargeListCompactToString(JsonData.largeListCompact)
    }

    @Benchmark
    fun encodeMacOsReleasesToString() {
        MoshiPrettyPrinted.encodeMacOsReleasesToString(JsonData.macosReleases)
    }

    @Benchmark
    fun encodePolymorphicGeoToString() {
        MoshiPrettyPrinted.encodePolymorphicGeoToString(JsonData.polymorphicGeo)
    }

    @Benchmark
    fun encodePolymorphicHtmlToString() {
        MoshiPrettyPrinted.encodePolymorphicHtmlToString(JsonData.polymorphicHtml)
    }

    @Benchmark
    fun encodeUserProfileToString() {
        MoshiPrettyPrinted.encodeUserProfileToString(JsonData.userProfile)
    }

//    @Benchmark
//    fun combined() {
//        MoshiPrettyPrinted.encodeLargeListToString(Data.largeList)
//        MoshiPrettyPrinted.encodeLargeListCompactToString(Data.largeListCompact)
//        MoshiPrettyPrinted.encodeMacOsReleasesToString(Data.macosReleases)
//        MoshiPrettyPrinted.encodePolymorphicGeoToString(Data.polymorphicGeo)
//        MoshiPrettyPrinted.encodePolymorphicHtmlToString(Data.polymorphicHtml)
//        MoshiPrettyPrinted.encodeUserProfileToString(Data.userProfile)
//    }
}