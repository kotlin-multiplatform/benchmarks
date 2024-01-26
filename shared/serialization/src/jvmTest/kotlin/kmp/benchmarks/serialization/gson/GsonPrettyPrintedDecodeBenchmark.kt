package kmp.benchmarks.serialization.gson

import kmp.benchmarks.serialization.JsonStrings
import kotlinx.benchmark.Benchmark
import kotlinx.benchmark.Scope
import kotlinx.benchmark.State

@State(Scope.Benchmark)
class GsonPrettyPrintedDecodeBenchmark {
    @Benchmark
    fun decodeLargeListFromString() {
        GsonPrettyPrinted.decodeLargeListFromString(JsonStrings.PrettyPrinted.largeList)
    }

    @Benchmark
    fun decodeLargeListCompactFromString() {
        GsonPrettyPrinted.decodeLargeListCompactFromString(JsonStrings.PrettyPrinted.largeList)
    }

    @Benchmark
    fun decodeMacOsReleasesFromString() {
        GsonPrettyPrinted.decodeMacOsReleasesFromString(JsonStrings.PrettyPrinted.macosReleases)
    }

    @Benchmark
    fun decodePolymorphicGeoFromString() {
        GsonPrettyPrinted.decodePolymorphicGeoFromString(JsonStrings.PrettyPrinted.polymorphicGeo)
    }

    @Benchmark
    fun decodePolymorphicHtmlFromString() {
        GsonPrettyPrinted.decodePolymorphicHtmlFromString(JsonStrings.PrettyPrinted.polymorphicHtml)
    }

    @Benchmark
    fun decodeUserProfileFromString() {
        GsonPrettyPrinted.decodeUserProfileFromString(JsonStrings.PrettyPrinted.userProfile)
    }

//    @Benchmark
//    fun combined() {
//        GsonPrettyPrinted.decodeLargeListFromString(Resources.PrettyPrintedJsonString.largeList)
//        GsonPrettyPrinted.decodeLargeListCompactFromString(Resources.PrettyPrintedJsonString.largeList)
//        GsonPrettyPrinted.decodeMacOsReleasesFromString(Resources.PrettyPrintedJsonString.macosReleases)
//        GsonPrettyPrinted.decodePolymorphicGeoFromString(Resources.PrettyPrintedJsonString.polymorphicGeo)
//        GsonPrettyPrinted.decodePolymorphicHtmlFromString(Resources.PrettyPrintedJsonString.polymorphicHtml)
//        GsonPrettyPrinted.decodeUserProfileFromString(Resources.PrettyPrintedJsonString.userProfile)
//    }
}