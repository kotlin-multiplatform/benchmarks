package kmp.benchmarks.serialization.gson

import com.goncalossilva.resources.Resource
import com.google.gson.reflect.TypeToken
import kmp.benchmarks.serialization.model.gson.GeoJSONObject
import kmp.benchmarks.serialization.model.gson.GithubPush
import kmp.benchmarks.serialization.model.gson.HtmlChunk
import kmp.benchmarks.serialization.model.gson.MacOsReleases
import kmp.benchmarks.serialization.model.gson.UserProfile
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class GsonTest {
    @Test
    fun `GIVEN large list json data WHEN fromJson is invoked THEN it does not fail`() {
        val jsonString = Resource("src/commonTest/resources/large-list.json").readText()

        val data: List<GithubPush> = gson.fromJson(jsonString, TypeToken.getParameterized(List::class.java, GithubPush::class.java).type)
        assertTrue(data.isNotEmpty())
    }

//    @Test
//    fun `GIVEN large list json data WHEN toJson is invoked THEN it does not fail`() {
//        val expectedJsonString = Resource("src/commonTest/resources/large-list.json").readText()
//
//        val data: List<GithubPush> = gson.fromJson(expectedJsonString, TypeToken.getParameterized(List::class.java, GithubPush::class.java).type)
//        assertEquals(expectedJsonString, gson.toJson(data))
//    }

    @Test
    fun `GIVEN macos releases json data WHEN fromJson is invoked THEN it does not fail`() {
        val jsonString = Resource("src/commonTest/resources/macos-releases.json").readText()

        val data: MacOsReleases = gson.fromJson(jsonString, MacOsReleases::class.java)
        assertTrue(data.versions.isNotEmpty())
    }

    @Test
    fun `GIVEN macos releases json data WHEN toJson is invoked THEN it does not fail`() {
        val expectedJsonString = Resource("src/commonTest/resources/macos-releases.json").readText()

        val data: MacOsReleases = gson.fromJson(expectedJsonString, MacOsReleases::class.java)
        assertEquals(expectedJsonString, gson.toJson(data))
    }

    @Test
    fun `GIVEN polymorphic geo json data WHEN fromJson is invoked THEN it does not fail`() {
        val jsonString = Resource("src/commonTest/resources/polymorphic-geo.json").readText()

        val data: List<GeoJSONObject> = gson.fromJson(jsonString, TypeToken.getParameterized(List::class.java, GeoJSONObject::class.java).type)
        assertTrue(data.isNotEmpty())
    }

    @Test
    fun `GIVEN polymorphic geo json data WHEN toJson is invoked THEN it does not fail`() {
        val expectedJsonString = Resource("src/commonTest/resources/polymorphic-geo.json").readText()

        val data: List<GeoJSONObject> = gson.fromJson(expectedJsonString, TypeToken.getParameterized(List::class.java, GeoJSONObject::class.java).type)
        assertEquals(expectedJsonString, gson.toJson(data, TypeToken.getParameterized(List::class.java, GeoJSONObject::class.java).type))
    }

    @Test
    fun `GIVEN polymorphic html json data WHEN fromJson is invoked THEN it does not fail`() {
        val jsonString = Resource("src/commonTest/resources/polymorphic-html.json").readText()

        val data: List<HtmlChunk> = gson.fromJson(jsonString, TypeToken.getParameterized(List::class.java, HtmlChunk::class.java).type)
        assertTrue(data.isNotEmpty())
    }

    @Test
    fun `GIVEN polymorphic html json data WHEN toJson is invoked THEN it does not fail`() {
        val expectedJsonString = Resource("src/commonTest/resources/polymorphic-html.json").readText()

        val data: List<HtmlChunk> = gson.fromJson(expectedJsonString, TypeToken.getParameterized(List::class.java, HtmlChunk::class.java).type)
        assertEquals(expectedJsonString, gson.toJson(data, TypeToken.getParameterized(List::class.java, HtmlChunk::class.java).type))
    }

    @Test
    fun `GIVEN user profile json data WHEN fromJson is invoked THEN it does not fail`() {
        val jsonString = Resource("src/commonTest/resources/user-profile.json").readText()

        val data: UserProfile = gson.fromJson(jsonString, UserProfile::class.java)
        assertTrue(data.personal.firstName.isNotEmpty())
    }

    @Test
    fun `GIVEN user profile json data WHEN toJson is invoked THEN it does not fail`() {
        val expectedJsonString = Resource("src/commonTest/resources/user-profile.json").readText()

        val data: UserProfile = gson.fromJson(expectedJsonString, UserProfile::class.java)
        assertEquals(expectedJsonString, gson.toJson(data))
    }
}