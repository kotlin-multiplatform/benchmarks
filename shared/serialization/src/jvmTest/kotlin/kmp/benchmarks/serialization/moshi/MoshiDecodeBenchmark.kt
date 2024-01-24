package kmp.benchmarks.serialization.moshi

import kmp.benchmarks.serialization.Resources
import kotlinx.benchmark.Benchmark
import kotlinx.benchmark.Scope
import kotlinx.benchmark.State

@State(Scope.Benchmark)
class MoshiDecodeBenchmark {
    @Benchmark
    fun decodeLargeListFromString() {
        Moshi.decodeLargeListFromString(Resources.MinimisedJsonString.largeList)
    }

    @Benchmark
    fun decodeLargeListCompactFromString() {
        Moshi.decodeLargeListCompactFromString(Resources.MinimisedJsonString.largeList)
    }

    @Benchmark
    fun decodeMacOsReleasesFromString() {
        Moshi.decodeMacOsReleasesFromString(Resources.MinimisedJsonString.macosReleases)
    }

    @Benchmark
    fun decodePolymorphicGeoFromString() {
        Moshi.decodePolymorphicGeoFromString(Resources.MinimisedJsonString.polymorphicGeo)
    }

    @Benchmark
    fun decodePolymorphicHtmlFromString() {
        Moshi.decodePolymorphicHtmlFromString(Resources.MinimisedJsonString.polymorphicHtml)
    }

    @Benchmark
    fun decodeUserProfileFromString() {
        Moshi.decodeUserProfileFromString(Resources.MinimisedJsonString.userProfile)
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