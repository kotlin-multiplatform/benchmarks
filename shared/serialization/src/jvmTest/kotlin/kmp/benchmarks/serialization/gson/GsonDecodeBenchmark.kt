package kmp.benchmarks.serialization.gson

import kmp.benchmarks.serialization.JsonStrings
import kotlinx.benchmark.Benchmark
import kotlinx.benchmark.Scope
import kotlinx.benchmark.State

@State(Scope.Benchmark)
class GsonDecodeBenchmark {
    @Benchmark
    fun decodeLargeListFromString() {
        Gson.decodeLargeListFromString(JsonStrings.Minimised.largeList)
    }

    @Benchmark
    fun decodeLargeListCompactFromString() {
        Gson.decodeLargeListCompactFromString(JsonStrings.Minimised.largeList)
    }

    @Benchmark
    fun decodeMacOsReleasesFromString() {
        Gson.decodeMacOsReleasesFromString(JsonStrings.Minimised.macosReleases)
    }

    @Benchmark
    fun decodePolymorphicGeoFromString() {
        Gson.decodePolymorphicGeoFromString(JsonStrings.Minimised.polymorphicGeo)
    }

    @Benchmark
    fun decodePolymorphicHtmlFromString() {
        Gson.decodePolymorphicHtmlFromString(JsonStrings.Minimised.polymorphicHtml)
    }

    @Benchmark
    fun decodeUserProfileFromString() {
        Gson.decodeUserProfileFromString(JsonStrings.Minimised.userProfile)
    }

//    @Benchmark
//    fun combined() {
//        Gson.decodeLargeListFromString(Resources.MinimisedJsonString.largeList)
//        Gson.decodeLargeListCompactFromString(Resources.MinimisedJsonString.largeList)
//        Gson.decodeMacOsReleasesFromString(Resources.MinimisedJsonString.macosReleases)
//        Gson.decodePolymorphicGeoFromString(Resources.MinimisedJsonString.polymorphicGeo)
//        Gson.decodePolymorphicHtmlFromString(Resources.MinimisedJsonString.polymorphicHtml)
//        Gson.decodeUserProfileFromString(Resources.MinimisedJsonString.userProfile)
//    }
}