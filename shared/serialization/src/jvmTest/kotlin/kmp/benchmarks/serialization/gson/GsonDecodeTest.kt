package kmp.benchmarks.serialization.gson

import kmp.benchmarks.serialization.Resources
import kmp.benchmarks.serialization.model.gson.GeoJSONObject
import kmp.benchmarks.serialization.model.gson.HtmlChunk
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class GsonDecodeTest {
    @Test
    fun decodeLargeListFromString() {
        val data = Gson.decodeLargeListFromString(Resources.MinimisedJsonString.largeList)
        assertEquals("2489651045", data.first().id)
        assertEquals("https://avatars.githubusercontent.com/u/665991?", data.first().actor.avatarUrl)
    }

    @Test
    fun decodeLargeListCompactFromString() {
        val data = Gson.decodeLargeListCompactFromString(Resources.MinimisedJsonString.largeList)
        assertEquals("2489651045", data.first().id)
        assertEquals("https://avatars.githubusercontent.com/u/665991?", data.first().actor.avatarUrl)
    }

    @Test
    fun decodeMacOsReleasesFromString() {
        val data = Gson.decodeMacOsReleasesFromString(Resources.MinimisedJsonString.macosReleases)
        assertEquals("Kodiak", data.versions.first().internal)
        assertEquals("US", data.versions.first().releases.first().version)
    }

    @Test
    fun decodePolymorphicGeoFromString() {
        val data = Gson.decodePolymorphicGeoFromString(Resources.MinimisedJsonString.polymorphicGeo)

        assertTrue(data.first() is GeoJSONObject.Point)
        assertEquals(listOf(100.0, 0.0), (data.first() as GeoJSONObject.Point).coordinates)
    }

    @Test
    fun decodePolymorphicHtmlFromString() {
        val data = Gson.decodePolymorphicHtmlFromString(Resources.MinimisedJsonString.polymorphicHtml)
        assertTrue(data.first() is HtmlChunk.Paragraph)
        assertTrue((data.first() as HtmlChunk.Paragraph).data.text.isNotBlank())
    }

    @Test
    fun decodeUserProfileFromString() {
        val data = Gson.decodeUserProfileFromString(Resources.MinimisedJsonString.userProfile)
        assertTrue(data.personal.firstName.isNotBlank())
    }
}