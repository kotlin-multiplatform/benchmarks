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
    fun `GIVEN large list json data WHEN decodeLargeListFromString is invoked THEN it does not fail`() {
        val jsonString = Resource("src/commonTest/resources/large-list.json").readText()

        val data = decodeLargeListFromString(jsonString)
        assertTrue(data.isNotEmpty())
    }

//    @Test
//    fun `GIVEN large list json data WHEN encodeLargeListToString is invoked THEN it does not fail`() {
//        val expectedJsonString = Resource("src/commonTest/resources/large-list.json").readText()
//
//        val data = decodeLargeListFromString(expectedJsonString)
//        assertEquals(expectedJsonString, encodeLargeListToString(data))
//    }

    @Test
    fun `GIVEN macos releases json data WHEN decodeMacOsReleasesFromString is invoked THEN it does not fail`() {
        val jsonString = Resource("src/commonTest/resources/macos-releases.json").readText()

        val data = decodeMacOsReleasesFromString(jsonString)
        assertTrue(data.versions.isNotEmpty())
    }

    @Test
    fun `GIVEN macos releases json data WHEN encodeMacOsReleasesToString is invoked THEN it does not fail`() {
        val expectedJsonString = Resource("src/commonTest/resources/macos-releases.json").readText()

        val data = decodeMacOsReleasesFromString(expectedJsonString)
        assertEquals(expectedJsonString, encodeMacOsReleasesToString(data))
    }

    @Test
    fun `GIVEN polymorphic geo json data WHEN decodePolymorphicGeoFromString is invoked THEN it does not fail`() {
        val jsonString = Resource("src/commonTest/resources/polymorphic-geo.json").readText()

        val data = decodePolymorphicGeoFromString(jsonString)
        assertTrue(data.isNotEmpty())
    }

    @Test
    fun `GIVEN polymorphic geo json data WHEN encodePolymorphicGeoToString is invoked THEN it does not fail`() {
        val expectedJsonString = Resource("src/commonTest/resources/polymorphic-geo.json").readText()

        val data = decodePolymorphicGeoFromString(expectedJsonString)
        assertEquals(expectedJsonString, encodePolymorphicGeoToString(data))
    }

    @Test
    fun `GIVEN polymorphic html json data WHEN decodePolymorphicHtmlFromString is invoked THEN it does not fail`() {
        val jsonString = Resource("src/commonTest/resources/polymorphic-html.json").readText()

        val data = decodePolymorphicHtmlFromString(jsonString)
        assertTrue(data.isNotEmpty())
    }

    @Test
    fun `GIVEN polymorphic html json data WHEN encodePolymorphicHtmlToString is invoked THEN it does not fail`() {
        val expectedJsonString = Resource("src/commonTest/resources/polymorphic-html.json").readText()

        val data = decodePolymorphicHtmlFromString(expectedJsonString)
        assertEquals(expectedJsonString, encodePolymorphicHtmlToString(data))
    }

    @Test
    fun `GIVEN user profile json data WHEN decodeUserProfileFromString is invoked THEN it does not fail`() {
        val jsonString = Resource("src/commonTest/resources/user-profile.json").readText()

        val data = decodeUserProfileFromString(jsonString)
        assertTrue(data.personal.firstName.isNotEmpty())
    }

    @Test
    fun `GIVEN user profile json data WHEN encodeUserProfileToString is invoked THEN it does not fail`() {
        val expectedJsonString = Resource("src/commonTest/resources/user-profile.json").readText()

        val data = decodeUserProfileFromString(expectedJsonString)
        assertEquals(expectedJsonString, encodeUserProfileToString(data))
    }
}