package kmp.benchmarks.serialization.kotlinxserialization

import kmp.benchmarks.serialization.Resources
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class KotlinxSerializationTest {
    @Test
    fun decodeLargeListFromString() {
        val data = KotlinxSerialization.decodeLargeListFromString(Resources.Minimised.largeListJsonString)
        assertTrue(data.isNotEmpty())
    }

//    @Test
//    fun encodeLargeListToString() {
//        val data = KotlinxSerialization.decodeLargeListFromString(Resources.Minimised.largeListJsonString)
//        assertEquals(Resources.Minimised.largeListJsonString, KotlinxSerialization.encodeLargeListToString(data))
//    }

    @Test
    fun decodeMacOsReleasesFromString() {
        val data = KotlinxSerialization.decodeMacOsReleasesFromString(Resources.Minimised.macosReleasesJsonString)
        assertTrue(data.versions.isNotEmpty())
    }

    @Test
    fun encodeMacOsReleasesToString() {
        val data = KotlinxSerialization.decodeMacOsReleasesFromString(Resources.Minimised.macosReleasesJsonString)
        assertEquals(Resources.Minimised.macosReleasesJsonString, KotlinxSerialization.encodeMacOsReleasesToString(data))
    }

    @Test
    fun decodePolymorphicGeoFromString() {
        val data = KotlinxSerialization.decodePolymorphicGeoFromString(Resources.Minimised.polymorphicGeoJsonString)
        assertTrue(data.isNotEmpty())
    }

    @Test
    fun encodePolymorphicGeoToString() {
        val data = KotlinxSerialization.decodePolymorphicGeoFromString(Resources.Minimised.polymorphicGeoJsonString)
        assertEquals(Resources.Minimised.polymorphicGeoJsonString, KotlinxSerialization.encodePolymorphicGeoToString(data))
    }

    @Test
    fun decodePolymorphicHtmlFromString() {
        val data = KotlinxSerialization.decodePolymorphicHtmlFromString(Resources.Minimised.polymorphicHtmlJsonString)
        assertTrue(data.isNotEmpty())
    }

    @Test
    fun encodePolymorphicHtmlToString() {
        val data = KotlinxSerialization.decodePolymorphicHtmlFromString(Resources.Minimised.polymorphicHtmlJsonString)
        assertEquals(Resources.Minimised.polymorphicHtmlJsonString, KotlinxSerialization.encodePolymorphicHtmlToString(data))
    }

    @Test
    fun decodeUserProfileFromString() {
        val data = KotlinxSerialization.decodeUserProfileFromString(Resources.Minimised.userProfileJsonString)
        assertTrue(data.personal.firstName.isNotEmpty())
    }

    @Test
    fun encodeUserProfileToString() {
        val data = KotlinxSerialization.decodeUserProfileFromString(Resources.Minimised.userProfileJsonString)
        assertEquals(Resources.Minimised.userProfileJsonString, KotlinxSerialization.encodeUserProfileToString(data))
    }
}