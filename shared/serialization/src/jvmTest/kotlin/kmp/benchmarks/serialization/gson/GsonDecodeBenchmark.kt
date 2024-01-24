package kmp.benchmarks.serialization.gson

import kmp.benchmarks.serialization.Resources
import kotlinx.benchmark.Benchmark
import kotlinx.benchmark.Scope
import kotlinx.benchmark.State

@State(Scope.Benchmark)
class GsonDecodeBenchmark {
    @Benchmark
    fun decodeLargeListFromString() {
        Gson.decodeLargeListFromString(Resources.MinimisedJsonString.largeList)
    }

    @Benchmark
    fun decodeLargeListCompactFromString() {
        Gson.decodeLargeListCompactFromString(Resources.MinimisedJsonString.largeList)
    }

    @Benchmark
    fun decodeMacOsReleasesFromString() {
        Gson.decodeMacOsReleasesFromString(Resources.MinimisedJsonString.macosReleases)
    }

    @Benchmark
    fun decodePolymorphicGeoFromString() {
        Gson.decodePolymorphicGeoFromString(Resources.MinimisedJsonString.polymorphicGeo)
    }

    @Benchmark
    fun decodePolymorphicHtmlFromString() {
        Gson.decodePolymorphicHtmlFromString(Resources.MinimisedJsonString.polymorphicHtml)
    }

    @Benchmark
    fun decodeUserProfileFromString() {
        Gson.decodeUserProfileFromString(Resources.MinimisedJsonString.userProfile)
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