package kmp.benchmarks.serialization.kotlinxserialization

import kmp.benchmarks.serialization.Resources
import kotlinx.benchmark.Benchmark
import kotlinx.benchmark.Scope
import kotlinx.benchmark.State

@State(Scope.Benchmark)
class KotlinxSerializationPrettyPrintedDecodeBenchmark {
    @Benchmark
    fun decodeLargeListFromString() {
        KotlinxSerializationPrettyPrinted.decodeLargeListFromString(Resources.PrettyPrinted.largeListJsonString)
    }

    @Benchmark
    fun decodeLargeListCompactFromString() {
        KotlinxSerializationPrettyPrinted.decodeLargeListCompactFromString(Resources.PrettyPrinted.largeListJsonString)
    }

    @Benchmark
    fun decodeMacOsReleasesFromString() {
        KotlinxSerializationPrettyPrinted.decodeMacOsReleasesFromString(Resources.PrettyPrinted.macosReleasesJsonString)
    }

    @Benchmark
    fun decodePolymorphicGeoFromString() {
        KotlinxSerializationPrettyPrinted.decodePolymorphicGeoFromString(Resources.PrettyPrinted.polymorphicGeoJsonString)
    }

    @Benchmark
    fun decodePolymorphicHtmlFromString() {
        KotlinxSerializationPrettyPrinted.decodePolymorphicHtmlFromString(Resources.PrettyPrinted.polymorphicHtmlJsonString)
    }

    @Benchmark
    fun decodeUserProfileFromString() {
        KotlinxSerializationPrettyPrinted.decodeUserProfileFromString(Resources.PrettyPrinted.userProfileJsonString)
    }

    @Benchmark
    fun combined() {
        KotlinxSerializationPrettyPrinted.decodeLargeListFromString(Resources.PrettyPrinted.largeListJsonString)
        KotlinxSerializationPrettyPrinted.decodeLargeListCompactFromString(Resources.PrettyPrinted.largeListJsonString)
        KotlinxSerializationPrettyPrinted.decodeMacOsReleasesFromString(Resources.PrettyPrinted.macosReleasesJsonString)
        KotlinxSerializationPrettyPrinted.decodePolymorphicGeoFromString(Resources.PrettyPrinted.polymorphicGeoJsonString)
        KotlinxSerializationPrettyPrinted.decodePolymorphicHtmlFromString(Resources.PrettyPrinted.polymorphicHtmlJsonString)
        KotlinxSerializationPrettyPrinted.decodeUserProfileFromString(Resources.PrettyPrinted.userProfileJsonString)
    }
}