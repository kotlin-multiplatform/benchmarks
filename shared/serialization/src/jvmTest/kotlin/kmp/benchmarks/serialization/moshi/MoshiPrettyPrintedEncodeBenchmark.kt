package kmp.benchmarks.serialization.moshi

import kmp.benchmarks.serialization.Resources
import kotlinx.benchmark.Benchmark
import kotlinx.benchmark.Scope
import kotlinx.benchmark.State

@State(Scope.Benchmark)
class MoshiPrettyPrintedEncodeBenchmark {
    @Benchmark
    fun encodeLargeListToString() {
        MoshiPrettyPrinted.encodeLargeListToString(Data.largeList)
    }

    @Benchmark
    fun encodeLargeListCompactToString() {
        MoshiPrettyPrinted.encodeLargeListCompactToString(Data.largeListCompact)
    }

    @Benchmark
    fun encodeMacOsReleasesToString() {
        MoshiPrettyPrinted.encodeMacOsReleasesToString(Data.macosReleases)
    }

    @Benchmark
    fun encodePolymorphicGeoToString() {
        MoshiPrettyPrinted.encodePolymorphicGeoToString(Data.polymorphicGeo)
    }

    @Benchmark
    fun encodePolymorphicHtmlToString() {
        MoshiPrettyPrinted.encodePolymorphicHtmlToString(Data.polymorphicHtml)
    }

    @Benchmark
    fun encodeUserProfileToString() {
        MoshiPrettyPrinted.encodeUserProfileToString(Data.userProfile)
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