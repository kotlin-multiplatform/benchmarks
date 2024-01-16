package kmp.benchmarks.serialization.kotlinxserialization

import kmp.benchmarks.serialization.Resources
import kotlinx.benchmark.Benchmark
import kotlinx.benchmark.Scope
import kotlinx.benchmark.State

@State(Scope.Benchmark)
class KotlinxSerializationBenchmark {
    @Benchmark
    fun decodeLargeListFromString() {
        KotlinxSerialization.decodeLargeListFromString(Resources.Minimised.largeListJsonString)
    }

    @Benchmark
    fun decodeMacOsReleasesFromString() {
        KotlinxSerialization.decodeMacOsReleasesFromString(Resources.Minimised.macosReleasesJsonString)
    }

    @Benchmark
    fun decodePolymorphicGeoFromString() {
        KotlinxSerialization.decodePolymorphicGeoFromString(Resources.Minimised.polymorphicGeoJsonString)
    }

    @Benchmark
    fun decodePolymorphicHtmlFromString() {
        KotlinxSerialization.decodePolymorphicHtmlFromString(Resources.Minimised.polymorphicHtmlJsonString)
    }

    @Benchmark
    fun decodeUserProfileFromString() {
        KotlinxSerialization.decodeUserProfileFromString(Resources.Minimised.userProfileJsonString)
    }

    @Benchmark
    fun combined() {
        KotlinxSerialization.decodeLargeListFromString(Resources.Minimised.largeListJsonString)
        KotlinxSerialization.decodeMacOsReleasesFromString(Resources.Minimised.macosReleasesJsonString)
        KotlinxSerialization.decodePolymorphicGeoFromString(Resources.Minimised.polymorphicGeoJsonString)
        KotlinxSerialization.decodePolymorphicHtmlFromString(Resources.Minimised.polymorphicHtmlJsonString)
        KotlinxSerialization.decodeUserProfileFromString(Resources.Minimised.userProfileJsonString)
    }
}