package kmp.benchmarks.serialization.gson

import kmp.benchmarks.serialization.Resources
import kotlinx.benchmark.Benchmark
import kotlinx.benchmark.Scope
import kotlinx.benchmark.State

@State(Scope.Benchmark)
class GsonPrettyPrintedDecodeBenchmark {
    @Benchmark
    fun decodeLargeListFromString() {
        GsonPrettyPrinted.decodeLargeListFromString(Resources.PrettyPrintedJsonString.largeList)
    }

    @Benchmark
    fun decodeLargeListCompactFromString() {
        GsonPrettyPrinted.decodeLargeListCompactFromString(Resources.PrettyPrintedJsonString.largeList)
    }

    @Benchmark
    fun decodeMacOsReleasesFromString() {
        GsonPrettyPrinted.decodeMacOsReleasesFromString(Resources.PrettyPrintedJsonString.macosReleases)
    }

    @Benchmark
    fun decodePolymorphicGeoFromString() {
        GsonPrettyPrinted.decodePolymorphicGeoFromString(Resources.PrettyPrintedJsonString.polymorphicGeo)
    }

    @Benchmark
    fun decodePolymorphicHtmlFromString() {
        GsonPrettyPrinted.decodePolymorphicHtmlFromString(Resources.PrettyPrintedJsonString.polymorphicHtml)
    }

    @Benchmark
    fun decodeUserProfileFromString() {
        GsonPrettyPrinted.decodeUserProfileFromString(Resources.PrettyPrintedJsonString.userProfile)
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