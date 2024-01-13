package kmp.benchmarks.serialization.kotlinxserialization

import com.goncalossilva.resources.Resource
import kotlinx.benchmark.Benchmark
import kotlinx.benchmark.Scope
import kotlinx.benchmark.State

@State(Scope.Benchmark)
class KotlinxSerializationBenchmark {
    private val largeListJsonString = Resource("src/commonTest/resources/large-list.json").readText()
    private val macosReleasesJsonString = Resource("src/commonTest/resources/macos-releases.json").readText()
    private val polymorphicGeoJsonString = Resource("src/commonTest/resources/polymorphic-geo.json").readText()
    private val polymorphicHtmlJsonString = Resource("src/commonTest/resources/polymorphic-html.json").readText()
    private val userProfileJsonString = Resource("src/commonTest/resources/user-profile.json").readText()

    @Benchmark
    fun decodeLargeListFromString() {
        decodeLargeListFromString(largeListJsonString)
    }

    @Benchmark
    fun decodeMacOsReleasesFromString() {
        decodeMacOsReleasesFromString(macosReleasesJsonString)
    }

    @Benchmark
    fun decodePolymorphicGeoFromString() {
        decodePolymorphicGeoFromString(polymorphicGeoJsonString)
    }

    @Benchmark
    fun decodePolymorphicHtmlFromString() {
        decodePolymorphicHtmlFromString(polymorphicHtmlJsonString)
    }

    @Benchmark
    fun decodeUserProfileFromString() {
        decodeUserProfileFromString(userProfileJsonString)
    }

    @Benchmark
    fun combined() {
        decodeLargeListFromString(largeListJsonString)
        decodeMacOsReleasesFromString(macosReleasesJsonString)
        decodePolymorphicGeoFromString(polymorphicGeoJsonString)
        decodePolymorphicHtmlFromString(polymorphicHtmlJsonString)
        decodeUserProfileFromString(userProfileJsonString)
    }
}