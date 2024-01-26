package kmp.benchmarks.serialization.moshi

import kmp.benchmarks.serialization.JsonStrings
import kmp.benchmarks.serialization.model.moshi.Coordinates
import kmp.benchmarks.serialization.model.moshi.GeoJSONObject
import kmp.benchmarks.serialization.model.moshi.HtmlChunk
import kmp.benchmarks.serialization.model.moshi.MacOsReleases
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class MoshiPrettyPrintedDecodeTest {
    @Test
    fun decodeLargeListFromString() {
        val data = MoshiPrettyPrinted.decodeLargeListFromString(JsonStrings.PrettyPrinted.largeList)

        assertEquals("2489651045", data.first().id)
        assertEquals("https://avatars.githubusercontent.com/u/665991?", data.first().actor.avatarUrl)
    }

    @Test
    fun decodeLargeListCompactFromString() {
        val data = MoshiPrettyPrinted.decodeLargeListCompactFromString(JsonStrings.PrettyPrinted.largeList)

        assertEquals("2489651045", data.first().id)
        assertEquals("https://avatars.githubusercontent.com/u/665991?", data.first().actor.avatarUrl)
    }

    @Test
    fun decodeMacOsReleasesFromString() {
        val data = MoshiPrettyPrinted.decodeMacOsReleasesFromString(JsonStrings.PrettyPrinted.macosReleases)

        assertEquals(MacOsReleases.External.KODIAK, data.versions.first().external)
        assertEquals("US", data.versions.first().releases.first().version)
    }

    @Test
    fun decodePolymorphicGeoFromString() {
        val data = MoshiPrettyPrinted.decodePolymorphicGeoFromString(JsonStrings.PrettyPrinted.polymorphicGeo)

        assertTrue(data.first() is GeoJSONObject.Point)
        assertEquals(Coordinates(100.0, 0.0), (data.first() as GeoJSONObject.Point).coordinates)
    }

    @Test
    fun decodePolymorphicHtmlFromString() {
        val data = MoshiPrettyPrinted.decodePolymorphicHtmlFromString(JsonStrings.PrettyPrinted.polymorphicHtml)

        assertTrue(data.first() is HtmlChunk.Paragraph)
        assertTrue((data.first() as HtmlChunk.Paragraph).data.text.isNotBlank())
    }

    @Test
    fun decodeUserProfileFromString() {
        val data = MoshiPrettyPrinted.decodeUserProfileFromString(JsonStrings.PrettyPrinted.userProfile)

        assertTrue(data.personal.firstName.isNotBlank())
    }
}