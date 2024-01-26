package kmp.benchmarks.serialization.moshi

import kmp.benchmarks.serialization.JsonStrings
import kotlinx.benchmark.Benchmark
import kotlinx.benchmark.Scope
import kotlinx.benchmark.State

@State(Scope.Benchmark)
class MoshiDecodeBenchmark {
    @Benchmark
    fun decodeLargeListFromString() {
        Moshi.decodeLargeListFromString(JsonStrings.Minimised.largeList)
    }

    @Benchmark
    fun decodeLargeListCompactFromString() {
        Moshi.decodeLargeListCompactFromString(JsonStrings.Minimised.largeList)
    }

    @Benchmark
    fun decodeMacOsReleasesFromString() {
        Moshi.decodeMacOsReleasesFromString(JsonStrings.Minimised.macosReleases)
    }

    @Benchmark
    fun decodePolymorphicGeoFromString() {
        Moshi.decodePolymorphicGeoFromString(JsonStrings.Minimised.polymorphicGeo)
    }

    @Benchmark
    fun decodePolymorphicHtmlFromString() {
        Moshi.decodePolymorphicHtmlFromString(JsonStrings.Minimised.polymorphicHtml)
    }

    @Benchmark
    fun decodeUserProfileFromString() {
        Moshi.decodeUserProfileFromString(JsonStrings.Minimised.userProfile)
    }

//    @Benchmark
//    fun combined() {
//        Moshi.decodeLargeListFromString(Resources.MinimisedJsonString.largeList)
//        Moshi.decodeLargeListCompactFromString(Resources.MinimisedJsonString.largeList)
//        Moshi.decodeMacOsReleasesFromString(Resources.MinimisedJsonString.macosReleases)
//        Moshi.decodePolymorphicGeoFromString(Resources.MinimisedJsonString.polymorphicGeo)
//        Moshi.decodePolymorphicHtmlFromString(Resources.MinimisedJsonString.polymorphicHtml)
//        Moshi.decodeUserProfileFromString(Resources.MinimisedJsonString.userProfile)
//    }
}