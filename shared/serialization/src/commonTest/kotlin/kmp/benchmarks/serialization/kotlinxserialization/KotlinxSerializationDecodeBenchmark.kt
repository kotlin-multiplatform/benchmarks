package kmp.benchmarks.serialization.kotlinxserialization

import kmp.benchmarks.serialization.Resources
import kotlinx.benchmark.Benchmark
import kotlinx.benchmark.Scope
import kotlinx.benchmark.State

@State(Scope.Benchmark)
class KotlinxSerializationDecodeBenchmark {
    @Benchmark
    fun decodeLargeListFromString() {
        KotlinxSerialization.decodeLargeListFromString(Resources.MinimisedJsonString.largeList)
    }

    @Benchmark
    fun decodeLargeListCompactFromString() {
        KotlinxSerialization.decodeLargeListCompactFromString(Resources.MinimisedJsonString.largeList)
    }

    @Benchmark
    fun decodeMacOsReleasesFromString() {
        KotlinxSerialization.decodeMacOsReleasesFromString(Resources.MinimisedJsonString.macosReleases)
    }

    @Benchmark
    fun decodePolymorphicGeoFromString() {
        KotlinxSerialization.decodePolymorphicGeoFromString(Resources.MinimisedJsonString.polymorphicGeo)
    }

    @Benchmark
    fun decodePolymorphicHtmlFromString() {
        KotlinxSerialization.decodePolymorphicHtmlFromString(Resources.MinimisedJsonString.polymorphicHtml)
    }

    @Benchmark
    fun decodeUserProfileFromString() {
        KotlinxSerialization.decodeUserProfileFromString(Resources.MinimisedJsonString.userProfile)
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