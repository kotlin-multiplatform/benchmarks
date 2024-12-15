package kmp.benchmarks.serialization.kotlinxserialization

import kotlinx.benchmark.Benchmark
import kotlinx.benchmark.Scope
import kotlinx.benchmark.State

@State(Scope.Benchmark)
class KotlinxSerializationPrettyPrintedEncodeBenchmark {
    @Benchmark
    fun encodeLargeListToString() {
        KotlinxSerializationPrettyPrinted.encodeLargeListToString(JsonData.largeList)
    }

    @Benchmark
    fun encodeLargeListCompactToString() {
        KotlinxSerializationPrettyPrinted.encodeLargeListCompactToString(JsonData.largeListCompact)
    }

    @Benchmark
    fun encodeMacOsReleasesToString() {
        KotlinxSerializationPrettyPrinted.encodeMacOsReleasesToString(JsonData.macosReleases)
    }

    @Benchmark
    fun encodePolymorphicGeoToString() {
        KotlinxSerializationPrettyPrinted.encodePolymorphicGeoToString(JsonData.polymorphicGeo)
    }

    @Benchmark
    fun encodePolymorphicHtmlToString() {
        KotlinxSerializationPrettyPrinted.encodePolymorphicHtmlToString(JsonData.polymorphicHtml)
    }

    @Benchmark
    fun encodeUserProfileToString() {
        KotlinxSerializationPrettyPrinted.encodeUserProfileToString(JsonData.userProfile)
        KotlinxSerializationPrettyPrinted.encodeUserProfileToString(FakeData.UserProfile.data)
    }
}