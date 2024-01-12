package kmp.benchmarks.serialization.gson

import com.goncalossilva.resources.Resource
import com.google.gson.reflect.TypeToken
import kmp.benchmarks.serialization.gson.gson
import kmp.benchmarks.serialization.model.gson.GeoJSONObject
import kmp.benchmarks.serialization.model.gson.GithubPush
import kmp.benchmarks.serialization.model.gson.HtmlChunk
import kmp.benchmarks.serialization.model.gson.MacOsReleases
import kmp.benchmarks.serialization.model.gson.UserProfile
import kotlinx.benchmark.Benchmark
import kotlinx.benchmark.Scope
import kotlinx.benchmark.State

@State(Scope.Benchmark)
class GsonBenchmark {
    private val largeListJsonString = Resource("src/commonTest/resources/large-list.json").readText()
    private val macosReleasesJsonString = Resource("src/commonTest/resources/macos-releases.json").readText()
    private val polymorphicGeoJsonString = Resource("src/commonTest/resources/polymorphic-geo.json").readText()
    private val polymorphicHtmlJsonString = Resource("src/commonTest/resources/polymorphic-html.json").readText()
    private val userProfileJsonString = Resource("src/commonTest/resources/user-profile.json").readText()

    @Benchmark
    fun `large list json data`() {
        gson.fromJson(largeListJsonString, TypeToken.getParameterized(List::class.java, GithubPush::class.java))
    }

    @Benchmark
    fun `macos releases json data`() {
        gson.fromJson(macosReleasesJsonString, MacOsReleases::class.java)
    }

    @Benchmark
    fun `polymorphic geo json data`() {
        gson.fromJson(polymorphicGeoJsonString, TypeToken.getParameterized(List::class.java, GeoJSONObject::class.java))
    }

    @Benchmark
    fun `polymorphic html json data`() {
        gson.fromJson(polymorphicHtmlJsonString, TypeToken.getParameterized(List::class.java, HtmlChunk::class.java))
    }

    @Benchmark
    fun `user profile json data`() {
        gson.fromJson(userProfileJsonString, UserProfile::class.java)
    }

    @Benchmark
    fun combined() {
        gson.fromJson(largeListJsonString, TypeToken.getParameterized(List::class.java, GithubPush::class.java))
        gson.fromJson(macosReleasesJsonString, MacOsReleases::class.java)
        gson.fromJson(polymorphicGeoJsonString, TypeToken.getParameterized(List::class.java, GeoJSONObject::class.java))
        gson.fromJson(polymorphicHtmlJsonString, TypeToken.getParameterized(List::class.java, HtmlChunk::class.java))
        gson.fromJson(userProfileJsonString, UserProfile::class.java)
    }
}