package kmp.benchmarks.serialization.kotlinxserialization

import kotlinx.benchmark.Benchmark
import kotlinx.benchmark.Scope
import kotlinx.benchmark.State

@State(Scope.Benchmark)
class KotlinxSerializationEncodeBenchmark {
    @Benchmark
    fun encodeLargeListToString() {
        KotlinxSerialization.encodeLargeListToString(JsonData.largeList)
    }

    @Benchmark
    fun encodeLargeListCompactToString() {
        KotlinxSerialization.encodeLargeListCompactToString(JsonData.largeListCompact)
    }

    @Benchmark
    fun encodeMacOsReleasesToString() {
        KotlinxSerialization.encodeMacOsReleasesToString(JsonData.macosReleases)
    }

    @Benchmark
    fun encodePolymorphicGeoToString() {
        KotlinxSerialization.encodePolymorphicGeoToString(JsonData.polymorphicGeo)
    }

    @Benchmark
    fun encodePolymorphicHtmlToString() {
        KotlinxSerialization.encodePolymorphicHtmlToString(JsonData.polymorphicHtml)
    }

    @Benchmark
    fun encodeUserProfileToString() {
        KotlinxSerialization.encodeUserProfileToString(JsonData.userProfile)
        KotlinxSerialization.encodeUserProfileToString(FakeData.UserProfile.data)
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