package kmp.benchmarks.serialization.kotlinxserialization

import kmp.benchmarks.serialization.Resources
import kotlinx.benchmark.Benchmark
import kotlinx.benchmark.Scope
import kotlinx.benchmark.State

@State(Scope.Benchmark)
class KotlinxSerializationEncodeBenchmark {
    @Benchmark
    fun encodeLargeListToString() {
        KotlinxSerialization.encodeLargeListToString(Data.largeList)
    }

    @Benchmark
    fun encodeLargeListCompactToString() {
        KotlinxSerialization.encodeLargeListCompactToString(Data.largeListCompact)
    }

    @Benchmark
    fun encodeMacOsReleasesToString() {
        KotlinxSerialization.encodeMacOsReleasesToString(Data.macosReleases)
    }

    @Benchmark
    fun encodePolymorphicGeoToString() {
        KotlinxSerialization.encodePolymorphicGeoToString(Data.polymorphicGeo)
    }

    @Benchmark
    fun encodePolymorphicHtmlToString() {
        KotlinxSerialization.encodePolymorphicHtmlToString(Data.polymorphicHtml)
    }

    @Benchmark
    fun encodeUserProfileToString() {
        KotlinxSerialization.encodeUserProfileToString(Data.userProfile)
    }

//    @Benchmark
//    fun combined() {
//        KotlinxSerialization.encodeLargeListToString(Data.largeList)
//        KotlinxSerialization.encodeLargeListCompactToString(Data.largeListCompact)
//        KotlinxSerialization.encodeMacOsReleasesToString(Data.macosReleases)
//        KotlinxSerialization.encodePolymorphicGeoToString(Data.polymorphicGeo)
//        KotlinxSerialization.encodePolymorphicHtmlToString(Data.polymorphicHtml)
//        KotlinxSerialization.encodeUserProfileToString(Data.userProfile)
//    }
}