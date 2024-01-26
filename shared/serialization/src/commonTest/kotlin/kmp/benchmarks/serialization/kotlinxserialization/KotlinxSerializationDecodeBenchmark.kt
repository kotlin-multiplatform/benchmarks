package kmp.benchmarks.serialization.kotlinxserialization

import kmp.benchmarks.serialization.JsonStrings
import kotlinx.benchmark.Benchmark
import kotlinx.benchmark.Scope
import kotlinx.benchmark.State

@State(Scope.Benchmark)
class KotlinxSerializationDecodeBenchmark {
    @Benchmark
    fun decodeLargeListFromString() {
        KotlinxSerialization.decodeLargeListFromString(JsonStrings.Minimised.largeList)
    }

    @Benchmark
    fun decodeLargeListCompactFromString() {
        KotlinxSerialization.decodeLargeListCompactFromString(JsonStrings.Minimised.largeList)
    }

    @Benchmark
    fun decodeMacOsReleasesFromString() {
        KotlinxSerialization.decodeMacOsReleasesFromString(JsonStrings.Minimised.macosReleases)
    }

    @Benchmark
    fun decodePolymorphicGeoFromString() {
        KotlinxSerialization.decodePolymorphicGeoFromString(JsonStrings.Minimised.polymorphicGeo)
    }

    @Benchmark
    fun decodePolymorphicHtmlFromString() {
        KotlinxSerialization.decodePolymorphicHtmlFromString(JsonStrings.Minimised.polymorphicHtml)
    }

    @Benchmark
    fun decodeUserProfileFromString() {
        KotlinxSerialization.decodeUserProfileFromString(JsonStrings.Minimised.userProfile)
    }

//    @Benchmark
//    fun combined() {
//        KotlinxSerialization.decodeLargeListFromString(Resources.MinimisedJsonString.largeList)
//        KotlinxSerialization.decodeLargeListCompactFromString(Resources.MinimisedJsonString.largeList)
//        KotlinxSerialization.decodeMacOsReleasesFromString(Resources.MinimisedJsonString.macosReleases)
//        KotlinxSerialization.decodePolymorphicGeoFromString(Resources.MinimisedJsonString.polymorphicGeo)
//        KotlinxSerialization.decodePolymorphicHtmlFromString(Resources.MinimisedJsonString.polymorphicHtml)
//        KotlinxSerialization.decodeUserProfileFromString(Resources.MinimisedJsonString.userProfile)
//    }
}