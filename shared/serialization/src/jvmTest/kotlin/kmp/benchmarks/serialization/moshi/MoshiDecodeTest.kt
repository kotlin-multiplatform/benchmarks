package kmp.benchmarks.serialization.moshi

import kmp.benchmarks.serialization.JsonStrings
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
        val data = Moshi.decodeLargeListFromString(JsonStrings.Minimised.largeList)

        assertEquals("2489651045", data.first().id)
        assertEquals("https://avatars.githubusercontent.com/u/665991?", data.first().actor.avatarUrl)
    }

    @Test
    fun decodeLargeListCompactFromString() {
        val data = Moshi.decodeLargeListCompactFromString(JsonStrings.Minimised.largeList)

        assertEquals("2489651045", data.first().id)
        assertEquals("https://avatars.githubusercontent.com/u/665991?", data.first().actor.avatarUrl)
    }

    @Test
    fun decodeMacOsReleasesFromString() {
        val data = Moshi.decodeMacOsReleasesFromString(JsonStrings.Minimised.macosReleases)

        assertEquals(MacOsReleases.External.KODIAK, data.versions.first().external)
        assertEquals("US", data.versions.first().releases.first().version)
    }

    @Test
    fun decodePolymorphicGeoFromString() {
        val data = Moshi.decodePolymorphicGeoFromString(JsonStrings.Minimised.polymorphicGeo)

        assertTrue(data.first() is GeoJSONObject.Point)
        assertEquals(Coordinates(100.0, 0.0), (data.first() as GeoJSONObject.Point).coordinates)
    }

    @Test
    fun decodePolymorphicHtmlFromString() {
        val data = Moshi.decodePolymorphicHtmlFromString(JsonStrings.Minimised.polymorphicHtml)

        assertTrue(data.first() is HtmlChunk.Paragraph)
        assertTrue((data.first() as HtmlChunk.Paragraph).data.text.isNotBlank())
    }

    @Test
    fun decodeUserProfileFromString() {
        val data = Moshi.decodeUserProfileFromString(JsonStrings.Minimised.userProfile)

        assertTrue(data.personal.firstName.isNotBlank())
    }
}