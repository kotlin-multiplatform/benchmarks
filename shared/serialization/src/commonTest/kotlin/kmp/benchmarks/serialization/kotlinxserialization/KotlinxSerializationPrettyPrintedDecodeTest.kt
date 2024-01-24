package kmp.benchmarks.serialization.kotlinxserialization

import kmp.benchmarks.serialization.Resources
import kmp.benchmarks.serialization.model.kotlinxserialization.GeoJSONObject
import kmp.benchmarks.serialization.model.kotlinxserialization.HtmlChunk
import kotlinx.serialization.SerializationException
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertTrue

class KotlinxSerializationPrettyPrintedDecodeTest {
    @Test
    fun decodeLargeListFromString() {
        KotlinxSerializationPrettyPrinted.decodeLargeListFromString("[]")

        val data = KotlinxSerializationPrettyPrinted.decodeLargeListFromString(Resources.PrettyPrintedJsonString.largeList)

        assertEquals("2489651045", data.first().id)
        assertEquals("https://avatars.githubusercontent.com/u/665991?", data.first().actor.avatarUrl)
    }

    @Test
    fun decodeLargeListFromString_fail() {
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

        val data = KotlinxSerializationPrettyPrinted.decodeLargeListCompactFromString(Resources.MinimisedJsonString.largeList)

        assertEquals("2489651045", data.first().id)
        assertEquals("https://avatars.githubusercontent.com/u/665991?", data.first().actor.avatarUrl)
    }

    @Test
    fun decodeLargeListCompactFromString_fail() {
        assertFailsWith<SerializationException> {
            KotlinxSerializationPrettyPrinted.decodeLargeListCompactFromString("{}")
        }

        assertFailsWith<SerializationException> {
            KotlinxSerializationPrettyPrinted.decodeLargeListCompactFromString("")
        }
    }

    @Test
    fun decodeMacOsReleasesFromString() {
        val data = KotlinxSerializationPrettyPrinted.decodeMacOsReleasesFromString(Resources.PrettyPrintedJsonString.macosReleases)

        assertEquals("Kodiak", data.versions.first().internal)
        assertEquals("US", data.versions.first().releases.first().version)
    }

    @Test
    fun decodeMacOsReleasesFromString_fail() {
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

        val data = KotlinxSerializationPrettyPrinted.decodePolymorphicGeoFromString(Resources.PrettyPrintedJsonString.polymorphicGeo)

        assertTrue(data.first() is GeoJSONObject.Point)
        assertEquals(listOf(100.0, 0.0), (data.first() as GeoJSONObject.Point).coordinates)
    }

    @Test
    fun decodePolymorphicGeoFromString_fail() {
        assertFailsWith<SerializationException> {
            KotlinxSerializationPrettyPrinted.decodePolymorphicGeoFromString("{}")
        }

        assertFailsWith<SerializationException> {
            KotlinxSerializationPrettyPrinted.decodePolymorphicGeoFromString("")
        }
    }

    @Test
    fun decodePolymorphicHtmlFromString() {
        val data = KotlinxSerializationPrettyPrinted.decodePolymorphicHtmlFromString(Resources.PrettyPrintedJsonString.polymorphicHtml)

        assertTrue(data.first() is HtmlChunk.Paragraph)
        assertTrue((data.first() as HtmlChunk.Paragraph).data.text.isNotBlank())
    }

    @Test
    fun decodePolymorphicHtmlFromString_fail() {
        assertFailsWith<SerializationException> {
            KotlinxSerializationPrettyPrinted.decodePolymorphicHtmlFromString("{}")
        }

        assertFailsWith<SerializationException> {
            KotlinxSerializationPrettyPrinted.decodePolymorphicHtmlFromString("")
        }
    }

    @Test
    fun decodeUserProfileFromString() {
        val data = KotlinxSerializationPrettyPrinted.decodeUserProfileFromString(Resources.PrettyPrintedJsonString.userProfile)

        assertTrue(data.personal.firstName.isNotBlank())
    }

    @Test
    fun decodeUserProfileFromString_fail() {
        assertFailsWith<SerializationException> {
            KotlinxSerializationPrettyPrinted.decodeUserProfileFromString("{}")
        }

        assertFailsWith<SerializationException> {
            KotlinxSerializationPrettyPrinted.decodeUserProfileFromString("")
        }
    }
}