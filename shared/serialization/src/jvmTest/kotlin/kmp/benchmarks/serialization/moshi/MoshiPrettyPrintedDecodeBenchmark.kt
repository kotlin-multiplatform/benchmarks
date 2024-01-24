package kmp.benchmarks.serialization.moshi

import kmp.benchmarks.serialization.Resources
import kotlinx.benchmark.Benchmark
import kotlinx.benchmark.Scope
import kotlinx.benchmark.State

@State(Scope.Benchmark)
class MoshiPrettyPrintedDecodeBenchmark {
    @Benchmark
    fun decodeLargeListFromString() {
        MoshiPrettyPrinted.decodeLargeListFromString(Resources.PrettyPrintedJsonString.largeList)
    }

    @Benchmark
    fun decodeLargeListCompactFromString() {
        MoshiPrettyPrinted.decodeLargeListCompactFromString(Resources.PrettyPrintedJsonString.largeList)
    }

    @Benchmark
    fun decodeMacOsReleasesFromString() {
        MoshiPrettyPrinted.decodeMacOsReleasesFromString(Resources.PrettyPrintedJsonString.macosReleases)
    }

    @Benchmark
    fun decodePolymorphicGeoFromString() {
        MoshiPrettyPrinted.decodePolymorphicGeoFromString(Resources.PrettyPrintedJsonString.polymorphicGeo)
    }

    @Benchmark
    fun decodePolymorphicHtmlFromString() {
        MoshiPrettyPrinted.decodePolymorphicHtmlFromString(Resources.PrettyPrintedJsonString.polymorphicHtml)
    }

    @Benchmark
    fun decodeUserProfileFromString() {
        MoshiPrettyPrinted.decodeUserProfileFromString(Resources.PrettyPrintedJsonString.userProfile)
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