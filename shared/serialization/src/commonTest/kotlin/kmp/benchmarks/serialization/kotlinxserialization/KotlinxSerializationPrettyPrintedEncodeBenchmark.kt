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
    }

//    @Benchmark
//    fun combined() {
//        KotlinxSerializationPrettyPrinted.encodeLargeListToString(Data.largeList)
//        KotlinxSerializationPrettyPrinted.encodeLargeListCompactToString(Data.largeListCompact)
//        KotlinxSerializationPrettyPrinted.encodeMacOsReleasesToString(Data.macosReleases)
//        KotlinxSerializationPrettyPrinted.encodePolymorphicGeoToString(Data.polymorphicGeo)
//        KotlinxSerializationPrettyPrinted.encodePolymorphicHtmlToString(Data.polymorphicHtml)
//        KotlinxSerializationPrettyPrinted.encodeUserProfileToString(Data.userProfile)
//    }
}