package kmp.benchmarks.serialization

import com.goncalossilva.resources.Resource
import kmp.benchmarks.serialization.kotlinxSerializationJson
import kmp.benchmarks.serialization.model.GeoJSONObject
import kmp.benchmarks.serialization.model.GithubPush
import kmp.benchmarks.serialization.model.HtmlChunk
import kmp.benchmarks.serialization.model.MacOsReleases
import kmp.benchmarks.serialization.model.UserProfile
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
    fun largeListBenchmark() {
        kotlinxSerializationJson.decodeFromString<List<GithubPush>>(largeListJsonString)
    }

    @Benchmark
    fun macosReleasesBenchmark() {
        kotlinxSerializationJson.decodeFromString<MacOsReleases>(macosReleasesJsonString)
    }

    @Benchmark
    fun polymorphicGeoBenchmark() {
        kotlinxSerializationJson.decodeFromString<List<GeoJSONObject>>(polymorphicGeoJsonString)
    }

    @Benchmark
    fun polymorphicHtmlBenchmark() {
        kotlinxSerializationJson.decodeFromString<List<HtmlChunk>>(polymorphicHtmlJsonString)
    }

    @Benchmark
    fun userProfileBenchmark() {
        kotlinxSerializationJson.decodeFromString<UserProfile>(userProfileJsonString)
    }

    @Benchmark
    fun combinedBenchmark() {
        kotlinxSerializationJson.decodeFromString<List<GithubPush>>(largeListJsonString)
        kotlinxSerializationJson.decodeFromString<MacOsReleases>(macosReleasesJsonString)
        kotlinxSerializationJson.decodeFromString<List<GeoJSONObject>>(polymorphicGeoJsonString)
        kotlinxSerializationJson.decodeFromString<List<HtmlChunk>>(polymorphicHtmlJsonString)
        kotlinxSerializationJson.decodeFromString<UserProfile>(userProfileJsonString)
    }
}