package kmp.benchmarks.serialization.gson

import kmp.benchmarks.serialization.JsonStrings
import kmp.benchmarks.serialization.model.gson.Coordinates
import kmp.benchmarks.serialization.model.gson.GeoJSONObject
import kmp.benchmarks.serialization.model.gson.HtmlChunk
import kmp.benchmarks.serialization.model.gson.MacOsReleases
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class GsonDecodeTest {
    @Test
    fun decodeLargeListFromString() {
        val data = Gson.decodeLargeListFromString(JsonStrings.Minimised.largeList)

        assertEquals("2489651045", data.first().id)
        assertEquals("https://avatars.githubusercontent.com/u/665991?", data.first().actor.avatarUrl)
    }

    @Test
    fun decodeLargeListCompactFromString() {
        val data = Gson.decodeLargeListCompactFromString(JsonStrings.Minimised.largeList)

        assertEquals("2489651045", data.first().id)
        assertEquals("https://avatars.githubusercontent.com/u/665991?", data.first().actor.avatarUrl)
    }

    @Test
    fun decodeMacOsReleasesFromString() {
        val data = Gson.decodeMacOsReleasesFromString(JsonStrings.Minimised.macosReleases)

        assertEquals(MacOsReleases.External.KODIAK, data.versions.first().external)
        assertEquals("US", data.versions.first().releases.first().version)
    }

    @Test
    fun decodePolymorphicGeoFromString() {
        val data = Gson.decodePolymorphicGeoFromString(JsonStrings.Minimised.polymorphicGeo)

        assertTrue(data.first() is GeoJSONObject.Point)
        assertEquals(Coordinates(100.0, 0.0), (data.first() as GeoJSONObject.Point).coordinates)
    }

    @Test
    fun decodePolymorphicHtmlFromString() {
        val data = Gson.decodePolymorphicHtmlFromString(JsonStrings.Minimised.polymorphicHtml)

        assertTrue(data.first() is HtmlChunk.Paragraph)
        assertTrue((data.first() as HtmlChunk.Paragraph).data.text.isNotBlank())
    }

    @Test
    fun decodeUserProfileFromString() {
        val data = Gson.decodeUserProfileFromString(JsonStrings.Minimised.userProfile)

        assertTrue(data.personal.firstName.isNotBlank())
    }
}