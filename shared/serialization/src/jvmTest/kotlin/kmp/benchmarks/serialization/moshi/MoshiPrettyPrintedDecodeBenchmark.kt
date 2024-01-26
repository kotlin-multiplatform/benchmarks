package kmp.benchmarks.serialization.moshi

import kmp.benchmarks.serialization.JsonStrings
import kotlinx.benchmark.Benchmark
import kotlinx.benchmark.Scope
import kotlinx.benchmark.State

@State(Scope.Benchmark)
class MoshiPrettyPrintedDecodeBenchmark {
    @Benchmark
    fun decodeLargeListFromString() {
        MoshiPrettyPrinted.decodeLargeListFromString(JsonStrings.PrettyPrinted.largeList)
    }

    @Benchmark
    fun decodeLargeListCompactFromString() {
        MoshiPrettyPrinted.decodeLargeListCompactFromString(JsonStrings.PrettyPrinted.largeList)
    }

    @Benchmark
    fun decodeMacOsReleasesFromString() {
        MoshiPrettyPrinted.decodeMacOsReleasesFromString(JsonStrings.PrettyPrinted.macosReleases)
    }

    @Benchmark
    fun decodePolymorphicGeoFromString() {
        MoshiPrettyPrinted.decodePolymorphicGeoFromString(JsonStrings.PrettyPrinted.polymorphicGeo)
    }

    @Benchmark
    fun decodePolymorphicHtmlFromString() {
        MoshiPrettyPrinted.decodePolymorphicHtmlFromString(JsonStrings.PrettyPrinted.polymorphicHtml)
    }

    @Benchmark
    fun decodeUserProfileFromString() {
        MoshiPrettyPrinted.decodeUserProfileFromString(JsonStrings.PrettyPrinted.userProfile)
    }

//    @Benchmark
//    fun combined() {
//        MoshiPrettyPrinted.decodeLargeListFromString(Resources.PrettyPrintedJsonString.largeList)
//        MoshiPrettyPrinted.decodeLargeListCompactFromString(Resources.PrettyPrintedJsonString.largeList)
//        MoshiPrettyPrinted.decodeMacOsReleasesFromString(Resources.PrettyPrintedJsonString.macosReleases)
//        MoshiPrettyPrinted.decodePolymorphicGeoFromString(Resources.PrettyPrintedJsonString.polymorphicGeo)
//        MoshiPrettyPrinted.decodePolymorphicHtmlFromString(Resources.PrettyPrintedJsonString.polymorphicHtml)
//        MoshiPrettyPrinted.decodeUserProfileFromString(Resources.PrettyPrintedJsonString.userProfile)
//    }
}