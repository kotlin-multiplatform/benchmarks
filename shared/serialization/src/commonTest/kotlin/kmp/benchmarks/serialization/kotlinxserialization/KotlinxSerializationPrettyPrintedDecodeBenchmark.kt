package kmp.benchmarks.serialization.kotlinxserialization

import kmp.benchmarks.serialization.JsonStrings
import kotlinx.benchmark.Benchmark
import kotlinx.benchmark.Scope
import kotlinx.benchmark.State

@State(Scope.Benchmark)
class KotlinxSerializationPrettyPrintedDecodeBenchmark {
    @Benchmark
    fun decodeLargeListFromString() {
        KotlinxSerializationPrettyPrinted.decodeLargeListFromString(JsonStrings.PrettyPrinted.largeList)
    }

    @Benchmark
    fun decodeLargeListCompactFromString() {
        KotlinxSerializationPrettyPrinted.decodeLargeListCompactFromString(JsonStrings.PrettyPrinted.largeList)
    }

    @Benchmark
    fun decodeMacOsReleasesFromString() {
        KotlinxSerializationPrettyPrinted.decodeMacOsReleasesFromString(JsonStrings.PrettyPrinted.macosReleases)
    }

    @Benchmark
    fun decodePolymorphicGeoFromString() {
        KotlinxSerializationPrettyPrinted.decodePolymorphicGeoFromString(JsonStrings.PrettyPrinted.polymorphicGeo)
    }

    @Benchmark
    fun decodePolymorphicHtmlFromString() {
        KotlinxSerializationPrettyPrinted.decodePolymorphicHtmlFromString(JsonStrings.PrettyPrinted.polymorphicHtml)
    }

    @Benchmark
    fun decodeUserProfileFromString() {
        KotlinxSerializationPrettyPrinted.decodeUserProfileFromString(JsonStrings.PrettyPrinted.userProfile)
    }
}