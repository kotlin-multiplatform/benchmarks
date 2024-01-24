package kmp.benchmarks.serialization.kotlinxserialization

import kmp.benchmarks.serialization.Resources
import kotlinx.benchmark.Benchmark
import kotlinx.benchmark.Scope
import kotlinx.benchmark.State

@State(Scope.Benchmark)
class KotlinxSerializationPrettyPrintedDecodeBenchmark {
    @Benchmark
    fun decodeLargeListFromString() {
        KotlinxSerializationPrettyPrinted.decodeLargeListFromString(Resources.PrettyPrintedJsonString.largeList)
    }

    @Benchmark
    fun decodeLargeListCompactFromString() {
        KotlinxSerializationPrettyPrinted.decodeLargeListCompactFromString(Resources.PrettyPrintedJsonString.largeList)
    }

    @Benchmark
    fun decodeMacOsReleasesFromString() {
        KotlinxSerializationPrettyPrinted.decodeMacOsReleasesFromString(Resources.PrettyPrintedJsonString.macosReleases)
    }

    @Benchmark
    fun decodePolymorphicGeoFromString() {
        KotlinxSerializationPrettyPrinted.decodePolymorphicGeoFromString(Resources.PrettyPrintedJsonString.polymorphicGeo)
    }

    @Benchmark
    fun decodePolymorphicHtmlFromString() {
        KotlinxSerializationPrettyPrinted.decodePolymorphicHtmlFromString(Resources.PrettyPrintedJsonString.polymorphicHtml)
    }

    @Benchmark
    fun decodeUserProfileFromString() {
        KotlinxSerializationPrettyPrinted.decodeUserProfileFromString(Resources.PrettyPrintedJsonString.userProfile)
    }

//    @Benchmark
//    fun combined() {
//        KotlinxSerializationPrettyPrinted.decodeLargeListFromString(Resources.PrettyPrintedJsonString.largeList)
//        KotlinxSerializationPrettyPrinted.decodeLargeListCompactFromString(Resources.PrettyPrintedJsonString.largeList)
//        KotlinxSerializationPrettyPrinted.decodeMacOsReleasesFromString(Resources.PrettyPrintedJsonString.macosReleases)
//        KotlinxSerializationPrettyPrinted.decodePolymorphicGeoFromString(Resources.PrettyPrintedJsonString.polymorphicGeo)
//        KotlinxSerializationPrettyPrinted.decodePolymorphicHtmlFromString(Resources.PrettyPrintedJsonString.polymorphicHtml)
//        KotlinxSerializationPrettyPrinted.decodeUserProfileFromString(Resources.PrettyPrintedJsonString.userProfile)
//    }
}