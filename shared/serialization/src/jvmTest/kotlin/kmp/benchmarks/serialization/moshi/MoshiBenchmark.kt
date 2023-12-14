package kmp.benchmarks.serialization.moshi

import com.goncalossilva.resources.Resource
import com.squareup.moshi.adapter
import kmp.benchmarks.serialization.model.moshi.GeoJSONObject
import kmp.benchmarks.serialization.model.moshi.GithubPush
import kmp.benchmarks.serialization.model.moshi.HtmlChunk
import kmp.benchmarks.serialization.model.moshi.MacOsReleases
import kmp.benchmarks.serialization.model.moshi.UserProfile
import kmp.benchmarks.serialization.moshi.moshi
import kotlinx.benchmark.Benchmark
import kotlinx.benchmark.Scope
import kotlinx.benchmark.State

@OptIn(ExperimentalStdlibApi::class)
@State(Scope.Benchmark)
class MoshiBenchmark {
    private val largeListJsonString = Resource("src/commonTest/resources/large-list.json").readText()
    private val macosReleasesJsonString = Resource("src/commonTest/resources/macos-releases.json").readText()
    private val polymorphicGeoJsonString = Resource("src/commonTest/resources/polymorphic-geo.json").readText()
    private val polymorphicHtmlJsonString = Resource("src/commonTest/resources/polymorphic-html.json").readText()
    private val userProfileJsonString = Resource("src/commonTest/resources/user-profile.json").readText()

    @Benchmark
    fun largeListBenchmark() {
        moshi.adapter<List<GithubPush>>().fromJson(largeListJsonString)!!
    }

    @Benchmark
    fun macosReleasesBenchmark() {
        moshi.adapter<MacOsReleases>().fromJson(macosReleasesJsonString)!!
    }

    @Benchmark
    fun polymorphicGeoBenchmark() {
        moshi.adapter<List<GeoJSONObject>>().fromJson(polymorphicGeoJsonString)!!
    }

    @Benchmark
    fun polymorphicHtmlBenchmark() {
        moshi.adapter<List<HtmlChunk>>().fromJson(polymorphicHtmlJsonString)!!
    }

    @Benchmark
    fun userProfileBenchmark() {
        moshi.adapter<UserProfile>().fromJson(userProfileJsonString)!!
    }

    @Benchmark
    fun combinedBenchmark() {
        moshi.adapter<List<GithubPush>>().fromJson(largeListJsonString)!!
        moshi.adapter<MacOsReleases>().fromJson(macosReleasesJsonString)!!
        moshi.adapter<List<GeoJSONObject>>().fromJson(polymorphicGeoJsonString)!!
        moshi.adapter<List<HtmlChunk>>().fromJson(polymorphicHtmlJsonString)!!
        moshi.adapter<UserProfile>().fromJson(userProfileJsonString)!!
    }
}