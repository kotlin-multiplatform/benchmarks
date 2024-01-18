package kmp.benchmarks.serialization.gson

import kmp.benchmarks.serialization.Resources
import kmp.benchmarks.serialization.model.gson.GeoJSONObject
import kmp.benchmarks.serialization.model.gson.HtmlChunk
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class GsonPrettyPrintedDecodeTest {
    @Test
    fun decodeLargeListFromString() {
        val data = GsonPrettyPrinted.decodeLargeListFromString(Resources.PrettyPrinted.largeListJsonString)
        assertEquals("2489651045", data.first().id)
        assertEquals("https://avatars.githubusercontent.com/u/665991?", data.first().actor.avatarUrl)
    }

    @Test
    fun decodeLargeListCompactFromString() {
        val data = GsonPrettyPrinted.decodeLargeListCompactFromString(Resources.PrettyPrinted.largeListJsonString)
        assertEquals("2489651045", data.first().id)
        assertEquals("https://avatars.githubusercontent.com/u/665991?", data.first().actor.avatarUrl)
    }

    @Test
    fun decodeMacOsReleasesFromString() {
        val data = GsonPrettyPrinted.decodeMacOsReleasesFromString(Resources.PrettyPrinted.macosReleasesJsonString)
        assertEquals("Kodiak", data.versions.first().internal)
        assertEquals("US", data.versions.first().releases.first().version)
    }

    @Test
    fun decodePolymorphicGeoFromString() {
        val data = GsonPrettyPrinted.decodePolymorphicGeoFromString(Resources.PrettyPrinted.polymorphicGeoJsonString)
        assertTrue(data.first() is GeoJSONObject.Point)
        assertEquals(listOf(100.0, 0.0), (data.first() as GeoJSONObject.Point).coordinates)
    }

    @Test
    fun decodePolymorphicHtmlFromString() {
        val data = GsonPrettyPrinted.decodePolymorphicHtmlFromString(Resources.PrettyPrinted.polymorphicHtmlJsonString)
        assertTrue(data.first() is HtmlChunk.Paragraph)
        assertTrue((data.first() as HtmlChunk.Paragraph).data.text.isNotBlank())
    }

    @Test
    fun decodeUserProfileFromString() {
        val data = GsonPrettyPrinted.decodeUserProfileFromString(Resources.PrettyPrinted.userProfileJsonString)
        assertTrue(data.personal.firstName.isNotBlank())
    }
}