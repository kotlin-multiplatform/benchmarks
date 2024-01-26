package kmp.benchmarks.serialization.gson

import kotlinx.benchmark.Benchmark
import kotlinx.benchmark.Scope
import kotlinx.benchmark.State

@State(Scope.Benchmark)
class GsonPrettyPrintedEncodeBenchmark {
    @Benchmark
    fun encodeLargeListToString() {
        GsonPrettyPrinted.encodeLargeListToString(JsonData.largeList)
    }

    @Benchmark
    fun encodeLargeListCompactToString() {
        GsonPrettyPrinted.encodeLargeListCompactToString(JsonData.largeListCompact)
    }

    @Benchmark
    fun encodeMacOsReleasesToString() {
        GsonPrettyPrinted.encodeMacOsReleasesToString(JsonData.macosReleases)
    }

    @Benchmark
    fun encodePolymorphicGeoToString() {
        GsonPrettyPrinted.encodePolymorphicGeoToString(JsonData.polymorphicGeo)
    }

    @Benchmark
    fun encodePolymorphicHtmlToString() {
        GsonPrettyPrinted.encodePolymorphicHtmlToString(JsonData.polymorphicHtml)
    }

    @Benchmark
    fun encodeUserProfileToString() {
        GsonPrettyPrinted.encodeUserProfileToString(JsonData.userProfile)
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