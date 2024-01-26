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

class KotlinxSerializationPrettyPrintedDecodeTest {
    @Test
    fun decodeLargeListFromString() {
        KotlinxSerializationPrettyPrinted.decodeLargeListFromString("[]")

        val data = KotlinxSerializationPrettyPrinted.decodeLargeListFromString(JsonStrings.PrettyPrinted.largeList)

        assertEquals("2489651045", data.first().id)
        assertEquals("https://avatars.githubusercontent.com/u/665991?", data.first().actor.avatarUrl)
    }

    @Test
    fun decodeLargeListFromString_failed() {
        assertFailsWith<SerializationException> {
            KotlinxSerializationPrettyPrinted.decodeLargeListFromString("{}")
        }

        assertFailsWith<SerializationException> {
            KotlinxSerializationPrettyPrinted.decodeLargeListFromString("")
        }
    }

    @Test
    fun decodeLargeListCompactFromString() {
        KotlinxSerializationPrettyPrinted.decodeLargeListCompactFromString("[]")

        val data = KotlinxSerializationPrettyPrinted.decodeLargeListCompactFromString(JsonStrings.Minimised.largeList)

        assertEquals("2489651045", data.first().id)
        assertEquals("https://avatars.githubusercontent.com/u/665991?", data.first().actor.avatarUrl)
    }

    @Test
    fun decodeLargeListCompactFromString_failed() {
        assertFailsWith<SerializationException> {
            KotlinxSerializationPrettyPrinted.decodeLargeListCompactFromString("{}")
        }

        assertFailsWith<SerializationException> {
            KotlinxSerializationPrettyPrinted.decodeLargeListCompactFromString("")
        }
    }

    @Test
    fun decodeMacOsReleasesFromString() {
        val data = KotlinxSerializationPrettyPrinted.decodeMacOsReleasesFromString(JsonStrings.PrettyPrinted.macosReleases)

        assertEquals(MacOsReleases.Version.External.KODIAK, data.versions.first().external)
        assertEquals("US", data.versions.first().releases.first().version)
    }

    @Test
    fun decodeMacOsReleasesFromString_failed() {
        assertFailsWith<SerializationException> {
            KotlinxSerializationPrettyPrinted.decodeMacOsReleasesFromString("{}")
        }

        assertFailsWith<SerializationException> {
            KotlinxSerializationPrettyPrinted.decodeMacOsReleasesFromString("")
        }
    }

    @Test
    fun decodePolymorphicGeoFromString() {
        KotlinxSerializationPrettyPrinted.decodePolymorphicGeoFromString("[]")

        val data = KotlinxSerializationPrettyPrinted.decodePolymorphicGeoFromString(JsonStrings.PrettyPrinted.polymorphicGeo)

        assertTrue(data.first() is GeoJSONObject.Point)
        assertEquals(Coordinates(100.0, 0.0), (data.first() as GeoJSONObject.Point).coordinates)
    }

    @Test
    fun decodePolymorphicGeoFromString_failed() {
        assertFailsWith<SerializationException> {
            KotlinxSerializationPrettyPrinted.decodePolymorphicGeoFromString("{}")
        }

        assertFailsWith<SerializationException> {
            KotlinxSerializationPrettyPrinted.decodePolymorphicGeoFromString("")
        }
    }

    @Test
    fun decodePolymorphicHtmlFromString() {
        val data = KotlinxSerializationPrettyPrinted.decodePolymorphicHtmlFromString(JsonStrings.PrettyPrinted.polymorphicHtml)

        assertTrue(data.first() is HtmlChunk.Paragraph)
        assertTrue((data.first() as HtmlChunk.Paragraph).data.text.isNotBlank())
    }

    @Test
    fun decodePolymorphicHtmlFromString_failed() {
        assertFailsWith<SerializationException> {
            KotlinxSerializationPrettyPrinted.decodePolymorphicHtmlFromString("{}")
        }

        assertFailsWith<SerializationException> {
            KotlinxSerializationPrettyPrinted.decodePolymorphicHtmlFromString("")
        }
    }

    @Test
    fun decodeUserProfileFromString() {
        val data = KotlinxSerializationPrettyPrinted.decodeUserProfileFromString(JsonStrings.PrettyPrinted.userProfile)

        assertTrue(data.personal.firstName.isNotBlank())
    }

    @Test
    fun decodeUserProfileFromString_failed() {
        assertFailsWith<SerializationException> {
            KotlinxSerializationPrettyPrinted.decodeUserProfileFromString("{}")
        }

        assertFailsWith<SerializationException> {
            KotlinxSerializationPrettyPrinted.decodeUserProfileFromString("")
        }
    }
}