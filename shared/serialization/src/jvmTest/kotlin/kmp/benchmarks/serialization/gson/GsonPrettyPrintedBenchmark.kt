package kmp.benchmarks.serialization.gson

import kmp.benchmarks.serialization.Resources
import kotlinx.benchmark.Benchmark
import kotlinx.benchmark.Scope
import kotlinx.benchmark.State

@State(Scope.Benchmark)
class GsonPrettyPrintedBenchmark {

    @Benchmark
    fun decodeLargeListFromString() {
        GsonPrettyPrinted.decodeLargeListFromString(Resources.PrettyPrinted.largeListJsonString)
    }

    @Benchmark
    fun decodeMacOsReleasesFromString() {
        GsonPrettyPrinted.decodeMacOsReleasesFromString(Resources.PrettyPrinted.macosReleasesJsonString)
    }

    @Benchmark
    fun decodePolymorphicGeoFromString() {
        GsonPrettyPrinted.decodePolymorphicGeoFromString(Resources.PrettyPrinted.polymorphicGeoJsonString)
    }

    @Benchmark
    fun decodePolymorphicHtmlFromString() {
        GsonPrettyPrinted.decodePolymorphicHtmlFromString(Resources.PrettyPrinted.polymorphicHtmlJsonString)
    }

    @Benchmark
    fun decodeUserProfileFromString() {
        GsonPrettyPrinted.decodeUserProfileFromString(Resources.PrettyPrinted.userProfileJsonString)
    }

    @Benchmark
    fun combined() {
        GsonPrettyPrinted.decodeLargeListFromString(Resources.PrettyPrinted.largeListJsonString)
        GsonPrettyPrinted.decodeMacOsReleasesFromString(Resources.PrettyPrinted.macosReleasesJsonString)
        GsonPrettyPrinted.decodePolymorphicGeoFromString(Resources.PrettyPrinted.polymorphicGeoJsonString)
        GsonPrettyPrinted.decodePolymorphicHtmlFromString(Resources.PrettyPrinted.polymorphicHtmlJsonString)
        GsonPrettyPrinted.decodeUserProfileFromString(Resources.PrettyPrinted.userProfileJsonString)
    }
}