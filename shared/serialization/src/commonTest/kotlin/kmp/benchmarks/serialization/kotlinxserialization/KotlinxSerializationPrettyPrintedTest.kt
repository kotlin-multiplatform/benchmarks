package kmp.benchmarks.serialization.kotlinxserialization

import kmp.benchmarks.serialization.Resources
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class KotlinxSerializationPrettyPrintedTest {
    @Test
    fun decodeLargeListFromString() {
        val data = KotlinxSerializationPrettyPrinted.decodeLargeListFromString(Resources.PrettyPrinted.largeListJsonString)
        assertTrue(data.isNotEmpty())
    }

//    @Test
//    fun encodeLargeListToString() {
//        val data = KotlinxSerializationPrettyPrinted.decodeLargeListFromString(Resources.PrettyPrinted.largeListJsonString)
//        assertEquals(Resources.PrettyPrinted.largeListJsonString, KotlinxSerializationPrettyPrinted.encodeLargeListToString(data))
//    }

    @Test
    fun decodeMacOsReleasesFromString() {
        val data = KotlinxSerializationPrettyPrinted.decodeMacOsReleasesFromString(Resources.PrettyPrinted.macosReleasesJsonString)
        assertTrue(data.versions.isNotEmpty())
    }

    @Test
    fun encodeMacOsReleasesToString() {
        val data = KotlinxSerializationPrettyPrinted.decodeMacOsReleasesFromString(Resources.PrettyPrinted.macosReleasesJsonString)
        assertEquals(Resources.PrettyPrinted.macosReleasesJsonString, KotlinxSerializationPrettyPrinted.encodeMacOsReleasesToString(data))
    }

    @Test
    fun decodePolymorphicGeoFromString() {
        val data = KotlinxSerializationPrettyPrinted.decodePolymorphicGeoFromString(Resources.PrettyPrinted.polymorphicGeoJsonString)
        assertTrue(data.isNotEmpty())
    }

    @Test
    fun encodePolymorphicGeoToString() {
        val data = KotlinxSerializationPrettyPrinted.decodePolymorphicGeoFromString(Resources.PrettyPrinted.polymorphicGeoJsonString)
        assertEquals(Resources.PrettyPrinted.polymorphicGeoJsonString, KotlinxSerializationPrettyPrinted.encodePolymorphicGeoToString(data))
    }

    @Test
    fun decodePolymorphicHtmlFromString() {
        val data = KotlinxSerializationPrettyPrinted.decodePolymorphicHtmlFromString(Resources.PrettyPrinted.polymorphicHtmlJsonString)
        assertTrue(data.isNotEmpty())
    }

    @Test
    fun encodePolymorphicHtmlToString() {
        val data = KotlinxSerializationPrettyPrinted.decodePolymorphicHtmlFromString(Resources.PrettyPrinted.polymorphicHtmlJsonString)
        assertEquals(Resources.PrettyPrinted.polymorphicHtmlJsonString, KotlinxSerializationPrettyPrinted.encodePolymorphicHtmlToString(data))
    }

    @Test
    fun decodeUserProfileFromString() {
        val data = KotlinxSerializationPrettyPrinted.decodeUserProfileFromString(Resources.PrettyPrinted.userProfileJsonString)
        assertTrue(data.personal.firstName.isNotEmpty())
    }

    @Test
    fun encodeUserProfileToString() {
        val data = KotlinxSerializationPrettyPrinted.decodeUserProfileFromString(Resources.PrettyPrinted.userProfileJsonString)
        assertEquals(Resources.PrettyPrinted.userProfileJsonString, KotlinxSerializationPrettyPrinted.encodeUserProfileToString(data))
    }
}