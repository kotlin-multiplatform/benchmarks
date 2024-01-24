package kmp.benchmarks.serialization.gson

import kmp.benchmarks.serialization.Resources
import kotlinx.benchmark.Benchmark
import kotlinx.benchmark.Scope
import kotlinx.benchmark.State

@State(Scope.Benchmark)
class GsonPrettyPrintedEncodeBenchmark {
    @Benchmark
    fun encodeLargeListToString() {
        GsonPrettyPrinted.encodeLargeListToString(Data.largeList)
    }

    @Benchmark
    fun encodeLargeListCompactToString() {
        GsonPrettyPrinted.encodeLargeListCompactToString(Data.largeListCompact)
    }

    @Benchmark
    fun encodeMacOsReleasesToString() {
        GsonPrettyPrinted.encodeMacOsReleasesToString(Data.macosReleases)
    }

    @Benchmark
    fun encodePolymorphicGeoToString() {
        GsonPrettyPrinted.encodePolymorphicGeoToString(Data.polymorphicGeo)
    }

    @Benchmark
    fun encodePolymorphicHtmlToString() {
        GsonPrettyPrinted.encodePolymorphicHtmlToString(Data.polymorphicHtml)
    }

    @Benchmark
    fun encodeUserProfileToString() {
        GsonPrettyPrinted.encodeUserProfileToString(Data.userProfile)
    }

//    @Benchmark
//    fun combined() {
//        GsonPrettyPrinted.encodeLargeListToString(Data.largeList)
//        GsonPrettyPrinted.encodeLargeListCompactToString(Data.largeListCompact)
//        GsonPrettyPrinted.encodeMacOsReleasesToString(Data.macosReleases)
//        GsonPrettyPrinted.encodePolymorphicGeoToString(Data.polymorphicGeo)
//        GsonPrettyPrinted.encodePolymorphicHtmlToString(Data.polymorphicHtml)
//        GsonPrettyPrinted.encodeUserProfileToString(Data.userProfile)
//    }
}