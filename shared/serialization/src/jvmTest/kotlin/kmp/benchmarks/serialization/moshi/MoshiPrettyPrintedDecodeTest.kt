package kmp.benchmarks.serialization.moshi

import kmp.benchmarks.serialization.Resources
import kmp.benchmarks.serialization.model.moshi.GeoJSONObject
import kmp.benchmarks.serialization.model.moshi.HtmlChunk
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class MoshiPrettyPrintedDecodeTest {
    @Test
    fun decodeLargeListFromString() {
        val data = MoshiPrettyPrinted.decodeLargeListFromString(Resources.PrettyPrintedJsonString.largeList)
        assertEquals("2489651045", data.first().id)
        assertEquals("https://avatars.githubusercontent.com/u/665991?", data.first().actor.avatarUrl)
    }

    @Test
    fun decodeLargeListCompactFromString() {
        val data = MoshiPrettyPrinted.decodeLargeListCompactFromString(Resources.PrettyPrintedJsonString.largeList)
        assertEquals("2489651045", data.first().id)
        assertEquals("https://avatars.githubusercontent.com/u/665991?", data.first().actor.avatarUrl)
    }

    @Test
    fun decodeMacOsReleasesFromString() {
        val data = MoshiPrettyPrinted.decodeMacOsReleasesFromString(Resources.PrettyPrintedJsonString.macosReleases)
        assertEquals("Kodiak", data.versions.first().internal)
        assertEquals("US", data.versions.first().releases.first().version)
    }

    @Test
    fun decodePolymorphicGeoFromString() {
        val data = MoshiPrettyPrinted.decodePolymorphicGeoFromString(Resources.PrettyPrintedJsonString.polymorphicGeo)
        assertTrue(data.first() is GeoJSONObject.Point)
        assertEquals(listOf(100.0, 0.0), (data.first() as GeoJSONObject.Point).coordinates)
    }

    @Test
    fun decodePolymorphicHtmlFromString() {
        val data = MoshiPrettyPrinted.decodePolymorphicHtmlFromString(Resources.PrettyPrintedJsonString.polymorphicHtml)
        assertTrue(data.first() is HtmlChunk.Paragraph)
        assertTrue((data.first() as HtmlChunk.Paragraph).data.text.isNotBlank())
    }

    @Test
    fun decodeUserProfileFromString() {
        val data = MoshiPrettyPrinted.decodeUserProfileFromString(Resources.PrettyPrintedJsonString.userProfile)
        assertTrue(data.personal.firstName.isNotBlank())
    }
}