package kmp.benchmarks.serialization.kotlinxserialization

import kmp.benchmarks.serialization.Resources
import kotlinx.benchmark.Benchmark
import kotlinx.benchmark.Scope
import kotlinx.benchmark.State

@State(Scope.Benchmark)
class KotlinxSerializationPrettyPrintedEncodeBenchmark {
    @Benchmark
    fun encodeLargeListToString() {
        KotlinxSerializationPrettyPrinted.encodeLargeListToString(Data.largeList)
    }

    @Benchmark
    fun encodeLargeListCompactToString() {
        KotlinxSerializationPrettyPrinted.encodeLargeListCompactToString(Data.largeListCompact)
    }

    @Benchmark
    fun encodeMacOsReleasesToString() {
        KotlinxSerializationPrettyPrinted.encodeMacOsReleasesToString(Data.macosReleases)
    }

    @Benchmark
    fun encodePolymorphicGeoToString() {
        KotlinxSerializationPrettyPrinted.encodePolymorphicGeoToString(Data.polymorphicGeo)
    }

    @Benchmark
    fun encodePolymorphicHtmlToString() {
        KotlinxSerializationPrettyPrinted.encodePolymorphicHtmlToString(Data.polymorphicHtml)
    }

    @Benchmark
    fun encodeUserProfileToString() {
        KotlinxSerializationPrettyPrinted.encodeUserProfileToString(Data.userProfile)
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