package kmp.benchmarks.serialization.moshi

import com.goncalossilva.resources.Resource
import com.squareup.moshi.adapter
import kmp.benchmarks.serialization.model.moshi.GeoJSONObject
import kmp.benchmarks.serialization.model.moshi.GithubPush
import kmp.benchmarks.serialization.model.moshi.HtmlChunk
import kmp.benchmarks.serialization.model.moshi.MacOsReleases
import kmp.benchmarks.serialization.model.moshi.UserProfile
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

@OptIn(ExperimentalStdlibApi::class)
class MoshiTest {
    @Test
    fun `GIVEN large list json data WHEN fromJson is invoked THEN it doesnt fail`() {
        val jsonString = Resource("src/commonTest/resources/large-list.json").readText()

        val data: List<GithubPush> = moshi.adapter<List<GithubPush>>().fromJson(jsonString)!!
        assertTrue(data.isNotEmpty())
    }

//    @Test
//    fun `GIVEN large list json data WHEN toJson is invoked THEN it doesnt fail`() {
//        val expectedJsonString = Resource("src/commonTest/resources/large-list.json").readText()
//
//        val adapter = moshi.adapter<List<GithubPush>>().indent("  ").serializeNulls()
//
//        val data: List<GithubPush> = adapter.fromJson(expectedJsonString)!!
//        assertEquals(expectedJsonString, adapter.toJson(data))
//    }

    @Test
    fun `GIVEN macos releases json data WHEN fromJson is invoked THEN it doesnt fail`() {
        val jsonString = Resource("src/commonTest/resources/macos-releases.json").readText()

        val data: MacOsReleases = moshi.adapter<MacOsReleases>().fromJson(jsonString)!!
        assertTrue(data.versions.isNotEmpty())
    }

    @Test
    fun `GIVEN macos releases json data WHEN toJson is invoked THEN it doesnt fail`() {
        val expectedJsonString = Resource("src/commonTest/resources/macos-releases.json").readText()

        val adapter = moshi.adapter<MacOsReleases>().indent("  ").serializeNulls()

        val data: MacOsReleases = adapter.fromJson(expectedJsonString)!!
        assertEquals(expectedJsonString, adapter.toJson(data))
    }

    @Test
    fun `GIVEN polymorphic geo json data WHEN fromJson is invoked THEN it doesnt fail`() {
        val jsonString = Resource("src/commonTest/resources/polymorphic-geo.json").readText()

        val data: List<GeoJSONObject> = moshi.adapter<List<GeoJSONObject>>().fromJson(jsonString)!!
        assertTrue(data.isNotEmpty())
    }

    @Test
    fun `GIVEN polymorphic geo json data WHEN toJson is invoked THEN it doesnt fail`() {
        val expectedJsonString = Resource("src/commonTest/resources/polymorphic-geo.json").readText()

        val adapter = moshi.adapter<List<GeoJSONObject>>().indent("  ").serializeNulls()

        val data: List<GeoJSONObject> = adapter.fromJson(expectedJsonString)!!
        assertEquals(expectedJsonString, adapter.toJson(data))
    }

    @Test
    fun `GIVEN polymorphic html json data WHEN fromJson is invoked THEN it doesnt fail`() {
        val jsonString = Resource("src/commonTest/resources/polymorphic-html.json").readText()

        val data: List<HtmlChunk> = moshi.adapter<List<HtmlChunk>>().fromJson(jsonString)!!
        assertTrue(data.isNotEmpty())
    }

    @Test
    fun `GIVEN polymorphic html json data WHEN toJson is invoked THEN it doesnt fail`() {
        val expectedJsonString = Resource("src/commonTest/resources/polymorphic-html.json").readText()

        val adapter = moshi.adapter<List<HtmlChunk>>().indent("  ").serializeNulls()

        val data: List<HtmlChunk> = adapter.fromJson(expectedJsonString)!!
        assertEquals(expectedJsonString, adapter.toJson(data))
    }

    @Test
    fun `GIVEN user profile json data WHEN fromJson is invoked THEN it doesnt fail`() {
        val jsonString = Resource("src/commonTest/resources/user-profile.json").readText()

        val data: UserProfile = moshi.adapter<UserProfile>().fromJson(jsonString)!!
        assertTrue(data.personal.firstName.isNotEmpty())
    }

    @Test
    fun `GIVEN user profile json data WHEN toJson is invoked THEN it doesnt fail`() {
        val expectedJsonString = Resource("src/commonTest/resources/user-profile.json").readText()

        val adapter = moshi.adapter<UserProfile>().indent("  ").serializeNulls()

        val data: UserProfile = adapter.fromJson(expectedJsonString)!!
        assertEquals(expectedJsonString, adapter.toJson(data))
    }
}