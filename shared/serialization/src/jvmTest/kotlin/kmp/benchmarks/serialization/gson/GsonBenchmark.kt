package kmp.benchmarks.serialization.gson

import kmp.benchmarks.serialization.Resources
import kotlinx.benchmark.Benchmark
import kotlinx.benchmark.Scope
import kotlinx.benchmark.State

@State(Scope.Benchmark)
class GsonBenchmark {

    @Benchmark
    fun decodeLargeListFromString() {
        Gson.decodeLargeListFromString(Resources.Minimised.largeListJsonString)
    }

    @Benchmark
    fun decodeMacOsReleasesFromString() {
        Gson.decodeMacOsReleasesFromString(Resources.Minimised.macosReleasesJsonString)
    }

    @Benchmark
    fun decodePolymorphicGeoFromString() {
        Gson.decodePolymorphicGeoFromString(Resources.Minimised.polymorphicGeoJsonString)
    }

    @Benchmark
    fun decodePolymorphicHtmlFromString() {
        Gson.decodePolymorphicHtmlFromString(Resources.Minimised.polymorphicHtmlJsonString)
    }

    @Benchmark
    fun decodeUserProfileFromString() {
        Gson.decodeUserProfileFromString(Resources.Minimised.userProfileJsonString)
    }

    @Benchmark
    fun combined() {
        Gson.decodeLargeListFromString(Resources.Minimised.largeListJsonString)
        Gson.decodeMacOsReleasesFromString(Resources.Minimised.macosReleasesJsonString)
        Gson.decodePolymorphicGeoFromString(Resources.Minimised.polymorphicGeoJsonString)
        Gson.decodePolymorphicHtmlFromString(Resources.Minimised.polymorphicHtmlJsonString)
        Gson.decodeUserProfileFromString(Resources.Minimised.userProfileJsonString)
    }
}