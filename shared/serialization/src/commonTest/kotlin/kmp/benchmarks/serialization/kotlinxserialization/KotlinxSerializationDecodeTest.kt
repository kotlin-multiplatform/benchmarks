package kmp.benchmarks.serialization.kotlinxserialization

import kmp.benchmarks.serialization.JsonStrings
import kmp.benchmarks.serialization.model.kotlinxserialization.Coordinates
import kmp.benchmarks.serialization.model.kotlinxserialization.GeoJSONObject
import kmp.benchmarks.serialization.model.kotlinxserialization.HtmlChunk
import kmp.benchmarks.serialization.model.kotlinxserialization.MacOsReleases
import kotlinx.serialization.SerializationException
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertTrue

class KotlinxSerializationDecodeTest {
    @Test
    fun decodeLargeListFromString() {
        KotlinxSerialization.decodeLargeListFromString("[]")

        val data = KotlinxSerialization.decodeLargeListFromString(JsonStrings.Minimised.largeList)

        assertEquals("2489651045", data.first().id)
        assertEquals("https://avatars.githubusercontent.com/u/665991?", data.first().actor.avatarUrl)
    }

    @Test
    fun decodeLargeListFromString_failed() {
        assertFailsWith<SerializationException> {
            KotlinxSerialization.decodeLargeListFromString("{}")
        }

        assertFailsWith<SerializationException> {
            KotlinxSerialization.decodeLargeListFromString("")
        }
    }

    @Test
    fun decodeLargeListCompactFromString() {
        KotlinxSerialization.decodeLargeListCompactFromString("[]")

        val data = KotlinxSerialization.decodeLargeListCompactFromString(JsonStrings.Minimised.largeList)

        assertEquals("2489651045", data.first().id)
        assertEquals("https://avatars.githubusercontent.com/u/665991?", data.first().actor.avatarUrl)
    }

    @Test
    fun decodeLargeListCompactFromString_failed() {
        assertFailsWith<SerializationException> {
            KotlinxSerialization.decodeLargeListCompactFromString("{}")
        }

        assertFailsWith<SerializationException> {
            KotlinxSerialization.decodeLargeListCompactFromString("")
        }
    }

    @Test
    fun decodeMacOsReleasesFromString() {
        val data = KotlinxSerialization.decodeMacOsReleasesFromString(JsonStrings.Minimised.macosReleases)

        assertEquals(MacOsReleases.Version.External.KODIAK, data.versions.first().external)
        assertEquals("US", data.versions.first().releases.first().version)
    }

    @Test
    fun decodeMacOsReleasesFromString_failed() {
        assertFailsWith<SerializationException> {
            KotlinxSerialization.decodeMacOsReleasesFromString("{}")
        }

        assertFailsWith<SerializationException> {
            KotlinxSerialization.decodeMacOsReleasesFromString("")
        }
    }

    @Test
    fun decodePolymorphicGeoFromString() {
        KotlinxSerialization.decodePolymorphicGeoFromString("[]")

        val data = KotlinxSerialization.decodePolymorphicGeoFromString(JsonStrings.Minimised.polymorphicGeo)

        assertTrue(data.first() is GeoJSONObject.Point)
        assertEquals(Coordinates(100.0, 0.0), (data.first() as GeoJSONObject.Point).coordinates)
    }

    @Test
    fun decodePolymorphicGeoFromString_failed() {
        assertFailsWith<SerializationException> {
            KotlinxSerialization.decodePolymorphicGeoFromString("{}")
        }

        assertFailsWith<SerializationException> {
            KotlinxSerialization.decodePolymorphicGeoFromString("")
        }
    }

    @Test
    fun decodePolymorphicHtmlFromString() {
        KotlinxSerialization.decodePolymorphicHtmlFromString("[]")

        val data = KotlinxSerialization.decodePolymorphicHtmlFromString(JsonStrings.Minimised.polymorphicHtml)

        assertTrue(data.first() is HtmlChunk.Paragraph)
        assertTrue((data.first() as HtmlChunk.Paragraph).data.text.isNotBlank())
    }

    @Test
    fun decodePolymorphicHtmlFromString_failed() {
        assertFailsWith<SerializationException> {
            KotlinxSerialization.decodePolymorphicHtmlFromString("{}")
        }

        assertFailsWith<SerializationException> {
            KotlinxSerialization.decodePolymorphicHtmlFromString("")
        }
    }

    @Test
    fun decodeUserProfileFromString() {
        val data = KotlinxSerialization.decodeUserProfileFromString(JsonStrings.Minimised.userProfile)

        assertTrue(data.personal.firstName.isNotBlank())
    }

    @Test
    fun decodeUserProfileFromString_failed() {
        assertFailsWith<SerializationException> {
            KotlinxSerialization.decodeUserProfileFromString("{}")
        }

        assertFailsWith<SerializationException> {
            KotlinxSerialization.decodeUserProfileFromString("")
        }
    }
}