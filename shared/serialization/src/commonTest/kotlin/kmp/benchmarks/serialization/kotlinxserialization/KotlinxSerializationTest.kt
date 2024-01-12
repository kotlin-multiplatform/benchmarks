package kmp.benchmarks.serialization.kotlinxserialization

import com.goncalossilva.resources.Resource
import kmp.benchmarks.serialization.model.kotlinxserialization.GeoJSONObject
import kmp.benchmarks.serialization.model.kotlinxserialization.GithubPush
import kmp.benchmarks.serialization.model.kotlinxserialization.HtmlChunk
import kmp.benchmarks.serialization.model.kotlinxserialization.MacOsReleases
import kmp.benchmarks.serialization.model.kotlinxserialization.UserProfile
import kotlinx.serialization.encodeToString
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class KotlinxSerializationTest {
    @Test
    fun `GIVEN large list json data WHEN decodeFromString is invoked THEN it does not fail`() {
        val jsonString = Resource("src/commonTest/resources/large-list.json").readText()

        val data: List<GithubPush> = kotlinxSerializationJson.decodeFromString(jsonString)
        assertTrue(data.isNotEmpty())
    }

//    @Test
//    fun `GIVEN large list json data WHEN encodeToString is invoked THEN it does not fail`() {
//        val expectedJsonString = Resource("src/commonTest/resources/large-list.json").readText()
//
//        val data: List<GithubPush> = kotlinxSerializationJson.decodeFromString(expectedJsonString)
//        assertEquals(expectedJsonString, kotlinxSerializationJson.encodeToString(data))
//    }

    @Test
    fun `GIVEN macos releases json data WHEN decodeFromString is invoked THEN it does not fail`() {
        val jsonString = Resource("src/commonTest/resources/macos-releases.json").readText()

        val data: MacOsReleases = kotlinxSerializationJson.decodeFromString(jsonString)
        assertTrue(data.versions.isNotEmpty())
    }

    @Test
    fun `GIVEN macos releases json data WHEN encodeToString is invoked THEN it does not fail`() {
        val expectedJsonString = Resource("src/commonTest/resources/macos-releases.json").readText()

        val data: MacOsReleases = kotlinxSerializationJson.decodeFromString(expectedJsonString)
        assertEquals(expectedJsonString, kotlinxSerializationJson.encodeToString(data))
    }

    @Test
    fun `GIVEN polymorphic geo json data WHEN decodeFromString is invoked THEN it does not fail`() {
        val jsonString = Resource("src/commonTest/resources/polymorphic-geo.json").readText()

        val data: List<GeoJSONObject> = kotlinxSerializationJson.decodeFromString(jsonString)
        assertTrue(data.isNotEmpty())
    }

    @Test
    fun `GIVEN polymorphic geo json data WHEN encodeToString is invoked THEN it does not fail`() {
        val expectedJsonString = Resource("src/commonTest/resources/polymorphic-geo.json").readText()

        val data: List<GeoJSONObject> = kotlinxSerializationJson.decodeFromString(expectedJsonString)
        assertEquals(expectedJsonString, kotlinxSerializationJson.encodeToString(data))
    }

    @Test
    fun `GIVEN polymorphic html json data WHEN decodeFromString is invoked THEN it does not fail`() {
        val jsonString = Resource("src/commonTest/resources/polymorphic-html.json").readText()

        val data: List<HtmlChunk> = kotlinxSerializationJson.decodeFromString(jsonString)
        assertTrue(data.isNotEmpty())
    }

    @Test
    fun `GIVEN polymorphic html json data WHEN encodeToString is invoked THEN it does not fail`() {
        val expectedJsonString = Resource("src/commonTest/resources/polymorphic-html.json").readText()

        val data: List<HtmlChunk> = kotlinxSerializationJson.decodeFromString(expectedJsonString)
        assertEquals(expectedJsonString, kotlinxSerializationJson.encodeToString(data))
    }

    @Test
    fun `GIVEN user profile json data WHEN decodeFromString is invoked THEN it does not fail`() {
        val jsonString = Resource("src/commonTest/resources/user-profile.json").readText()

        val data: UserProfile = kotlinxSerializationJson.decodeFromString(jsonString)
        assertTrue(data.personal.firstName.isNotEmpty())
    }

    @Test
    fun `GIVEN user profile json data WHEN encodeToString is invoked THEN it does not fail`() {
        val expectedJsonString = Resource("src/commonTest/resources/user-profile.json").readText()

        val data: UserProfile = kotlinxSerializationJson.decodeFromString(expectedJsonString)
        assertEquals(expectedJsonString, kotlinxSerializationJson.encodeToString(data))
    }
}