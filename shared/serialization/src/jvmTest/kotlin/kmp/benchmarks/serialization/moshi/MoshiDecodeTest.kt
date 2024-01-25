package kmp.benchmarks.serialization.moshi

import kmp.benchmarks.serialization.Resources
import kmp.benchmarks.serialization.model.moshi.Coordinates
import kmp.benchmarks.serialization.model.moshi.GeoJSONObject
import kmp.benchmarks.serialization.model.moshi.HtmlChunk
import kmp.benchmarks.serialization.model.moshi.MacOsReleases
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class MoshiDecodeTest {
    @Test
    fun decodeLargeListFromString() {
        val data = Moshi.decodeLargeListFromString(Resources.MinimisedJsonString.largeList)
        assertEquals("2489651045", data.first().id)
        assertEquals("https://avatars.githubusercontent.com/u/665991?", data.first().actor.avatarUrl)
    }

    @Test
    fun decodeLargeListCompactFromString() {
        val data = Moshi.decodeLargeListCompactFromString(Resources.MinimisedJsonString.largeList)
        assertEquals("2489651045", data.first().id)
        assertEquals("https://avatars.githubusercontent.com/u/665991?", data.first().actor.avatarUrl)
    }

    @Test
    fun decodeMacOsReleasesFromString() {
        val data = Moshi.decodeMacOsReleasesFromString(Resources.MinimisedJsonString.macosReleases)
        assertEquals(MacOsReleases.External.KODIAK, data.versions.first().external)
        assertEquals("US", data.versions.first().releases.first().version)
    }

    @Test
    fun decodePolymorphicGeoFromString() {
        val data = Moshi.decodePolymorphicGeoFromString(Resources.MinimisedJsonString.polymorphicGeo)
        assertTrue(data.first() is GeoJSONObject.Point)
        assertEquals(Coordinates(100.0, 0.0), (data.first() as GeoJSONObject.Point).coordinates)
    }

    @Test
    fun decodePolymorphicHtmlFromString() {
        val data = Moshi.decodePolymorphicHtmlFromString(Resources.MinimisedJsonString.polymorphicHtml)
        assertTrue(data.first() is HtmlChunk.Paragraph)
        assertTrue((data.first() as HtmlChunk.Paragraph).data.text.isNotBlank())
    }

    @Test
    fun decodeUserProfileFromString() {
        val data = Moshi.decodeUserProfileFromString(Resources.MinimisedJsonString.userProfile)
        assertTrue(data.personal.firstName.isNotBlank())
    }
}