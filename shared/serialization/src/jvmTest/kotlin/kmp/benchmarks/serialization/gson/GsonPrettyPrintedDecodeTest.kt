package kmp.benchmarks.serialization.gson

import kmp.benchmarks.serialization.JsonStrings
import kmp.benchmarks.serialization.model.gson.Coordinates
import kmp.benchmarks.serialization.model.gson.GeoJSONObject
import kmp.benchmarks.serialization.model.gson.HtmlChunk
import kmp.benchmarks.serialization.model.gson.MacOsReleases
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class GsonPrettyPrintedDecodeTest {
    @Test
    fun decodeLargeListFromString() {
        val data = GsonPrettyPrinted.decodeLargeListFromString(JsonStrings.PrettyPrinted.largeList)

        assertEquals("2489651045", data.first().id)
        assertEquals("https://avatars.githubusercontent.com/u/665991?", data.first().actor.avatarUrl)
    }

    @Test
    fun decodeLargeListCompactFromString() {
        val data = GsonPrettyPrinted.decodeLargeListCompactFromString(JsonStrings.PrettyPrinted.largeList)

        assertEquals("2489651045", data.first().id)
        assertEquals("https://avatars.githubusercontent.com/u/665991?", data.first().actor.avatarUrl)
    }

    @Test
    fun decodeMacOsReleasesFromString() {
        val data = GsonPrettyPrinted.decodeMacOsReleasesFromString(JsonStrings.PrettyPrinted.macosReleases)

        assertEquals(MacOsReleases.External.KODIAK, data.versions.first().external)
        assertEquals("US", data.versions.first().releases.first().version)
    }

    @Test
    fun decodePolymorphicGeoFromString() {
        val data = GsonPrettyPrinted.decodePolymorphicGeoFromString(JsonStrings.PrettyPrinted.polymorphicGeo)

        assertTrue(data.first() is GeoJSONObject.Point)
        assertEquals(Coordinates(100.0, 0.0), (data.first() as GeoJSONObject.Point).coordinates)
    }

    @Test
    fun decodePolymorphicHtmlFromString() {
        val data = GsonPrettyPrinted.decodePolymorphicHtmlFromString(JsonStrings.PrettyPrinted.polymorphicHtml)

        assertTrue(data.first() is HtmlChunk.Paragraph)
        assertTrue((data.first() as HtmlChunk.Paragraph).data.text.isNotBlank())
    }

    @Test
    fun decodeUserProfileFromString() {
        val data = GsonPrettyPrinted.decodeUserProfileFromString(JsonStrings.PrettyPrinted.userProfile)

        assertTrue(data.personal.firstName.isNotBlank())
    }
}