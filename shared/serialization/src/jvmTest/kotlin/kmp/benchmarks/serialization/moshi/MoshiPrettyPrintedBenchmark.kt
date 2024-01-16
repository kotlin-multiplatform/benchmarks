package kmp.benchmarks.serialization.moshi

import kmp.benchmarks.serialization.Resources
import kotlinx.benchmark.Benchmark
import kotlinx.benchmark.Scope
import kotlinx.benchmark.State

@State(Scope.Benchmark)
class MoshiPrettyPrintedBenchmark {

    @Benchmark
    fun decodeLargeListFromString() {
        MoshiPrettyPrinted.decodeLargeListFromString(Resources.PrettyPrinted.largeListJsonString)
    }

    @Benchmark
    fun decodeMacOsReleasesFromString() {
        MoshiPrettyPrinted.decodeMacOsReleasesFromString(Resources.PrettyPrinted.macosReleasesJsonString)
    }

    @Benchmark
    fun decodePolymorphicGeoFromString() {
        MoshiPrettyPrinted.decodePolymorphicGeoFromString(Resources.PrettyPrinted.polymorphicGeoJsonString)
    }

    @Benchmark
    fun decodePolymorphicHtmlFromString() {
        MoshiPrettyPrinted.decodePolymorphicHtmlFromString(Resources.PrettyPrinted.polymorphicHtmlJsonString)
    }

    @Benchmark
    fun decodeUserProfileFromString() {
        MoshiPrettyPrinted.decodeUserProfileFromString(Resources.PrettyPrinted.userProfileJsonString)
    }

    @Benchmark
    fun combined() {
        MoshiPrettyPrinted.decodeLargeListFromString(Resources.PrettyPrinted.largeListJsonString)
        MoshiPrettyPrinted.decodeMacOsReleasesFromString(Resources.PrettyPrinted.macosReleasesJsonString)
        MoshiPrettyPrinted.decodePolymorphicGeoFromString(Resources.PrettyPrinted.polymorphicGeoJsonString)
        MoshiPrettyPrinted.decodePolymorphicHtmlFromString(Resources.PrettyPrinted.polymorphicHtmlJsonString)
        MoshiPrettyPrinted.decodeUserProfileFromString(Resources.PrettyPrinted.userProfileJsonString)
    }
}