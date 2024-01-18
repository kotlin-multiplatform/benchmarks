package kmp.benchmarks.serialization.moshi

import kmp.benchmarks.serialization.Resources
import kotlinx.benchmark.Benchmark
import kotlinx.benchmark.Scope
import kotlinx.benchmark.State

@State(Scope.Benchmark)
class MoshiDecodeBenchmark {
    @Benchmark
    fun decodeLargeListFromString() {
        Moshi.decodeLargeListFromString(Resources.Minimised.largeListJsonString)
    }

    @Benchmark
    fun decodeLargeListCompactFromString() {
        Moshi.decodeLargeListCompactFromString(Resources.Minimised.largeListJsonString)
    }

    @Benchmark
    fun decodeMacOsReleasesFromString() {
        Moshi.decodeMacOsReleasesFromString(Resources.Minimised.macosReleasesJsonString)
    }

    @Benchmark
    fun decodePolymorphicGeoFromString() {
        Moshi.decodePolymorphicGeoFromString(Resources.Minimised.polymorphicGeoJsonString)
    }

    @Benchmark
    fun decodePolymorphicHtmlFromString() {
        Moshi.decodePolymorphicHtmlFromString(Resources.Minimised.polymorphicHtmlJsonString)
    }

    @Benchmark
    fun decodeUserProfileFromString() {
        Moshi.decodeUserProfileFromString(Resources.Minimised.userProfileJsonString)
    }

    @Benchmark
    fun combined() {
        Moshi.decodeLargeListFromString(Resources.Minimised.largeListJsonString)
        Moshi.decodeLargeListCompactFromString(Resources.Minimised.largeListJsonString)
        Moshi.decodeMacOsReleasesFromString(Resources.Minimised.macosReleasesJsonString)
        Moshi.decodePolymorphicGeoFromString(Resources.Minimised.polymorphicGeoJsonString)
        Moshi.decodePolymorphicHtmlFromString(Resources.Minimised.polymorphicHtmlJsonString)
        Moshi.decodeUserProfileFromString(Resources.Minimised.userProfileJsonString)
    }
}