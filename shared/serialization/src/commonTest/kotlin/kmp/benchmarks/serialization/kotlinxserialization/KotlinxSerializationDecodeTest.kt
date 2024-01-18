package kmp.benchmarks.serialization.kotlinxserialization

import kmp.benchmarks.serialization.Resources
import kmp.benchmarks.serialization.model.kotlinxserialization.GeoJSONObject
import kmp.benchmarks.serialization.model.kotlinxserialization.HtmlChunk
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class KotlinxSerializationDecodeTest {
    @Test
    fun decodeLargeListFromString() {
        val data = KotlinxSerialization.decodeLargeListFromString(Resources.Minimised.largeListJsonString)
        assertEquals("2489651045", data.first().id)
        assertEquals("https://avatars.githubusercontent.com/u/665991?", data.first().actor.avatarUrl)
    }

    @Test
    fun decodeLargeListCompactFromString() {
        val data = KotlinxSerialization.decodeLargeListCompactFromString(Resources.Minimised.largeListJsonString)
        assertEquals("2489651045", data.first().id)
        assertEquals("https://avatars.githubusercontent.com/u/665991?", data.first().actor.avatarUrl)
    }

    @Test
    fun decodeMacOsReleasesFromString() {
        val data = KotlinxSerialization.decodeMacOsReleasesFromString(Resources.Minimised.macosReleasesJsonString)
        assertEquals("Kodiak", data.versions.first().internal)
        assertEquals("US", data.versions.first().releases.first().version)
    }

    @Test
    fun decodePolymorphicGeoFromString() {
        val data = KotlinxSerialization.decodePolymorphicGeoFromString(Resources.Minimised.polymorphicGeoJsonString)
        assertTrue(data.first() is GeoJSONObject.Point)
        assertEquals(listOf(100.0, 0.0), (data.first() as GeoJSONObject.Point).coordinates)
    }

    @Test
    fun decodePolymorphicHtmlFromString() {
        val data = KotlinxSerialization.decodePolymorphicHtmlFromString(Resources.Minimised.polymorphicHtmlJsonString)
        assertTrue(data.first() is HtmlChunk.Paragraph)
        assertTrue((data.first() as HtmlChunk.Paragraph).data.text.isNotBlank())
    }

    @Test
    fun decodeUserProfileFromString() {
        val data = KotlinxSerialization.decodeUserProfileFromString(Resources.Minimised.userProfileJsonString)
        assertTrue(data.personal.firstName.isNotBlank())
    }
}