package kmp.benchmarks.serialization.moshi

import kmp.benchmarks.serialization.Resources
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class MoshiTest {
    @Test
    fun decodeLargeListFromString() {
        val data = Moshi.decodeLargeListFromString(Resources.Minimised.largeListJsonString)
        assertTrue(data.isNotEmpty())
    }

//    @Test
//    fun encodeLargeListToString() {
//        val data = Moshi.decodeLargeListFromString(Resources.Minimised.largeListJsonString)
//        assertEquals(Resources.Minimised.largeListJsonString, Moshi.encodeLargeListToString(data))
//    }

    @Test
    fun decodeMacOsReleasesFromString() {
        val data = Moshi.decodeMacOsReleasesFromString(Resources.Minimised.macosReleasesJsonString)
        assertTrue(data.versions.isNotEmpty())
    }

    @Test
    fun encodeMacOsReleasesToString() {
        val data = Moshi.decodeMacOsReleasesFromString(Resources.Minimised.macosReleasesJsonString)
        assertEquals(Resources.Minimised.macosReleasesJsonString, Moshi.encodeMacOsReleasesToString(data))
    }

    @Test
    fun decodePolymorphicGeoFromString() {
        val data = Moshi.decodePolymorphicGeoFromString(Resources.Minimised.polymorphicGeoJsonString)
        assertTrue(data.isNotEmpty())
    }

    @Test
    fun encodePolymorphicGeoToString() {
        val data = Moshi.decodePolymorphicGeoFromString(Resources.Minimised.polymorphicGeoJsonString)
        assertEquals(Resources.Minimised.polymorphicGeoJsonString, Moshi.encodePolymorphicGeoToString(data))
    }

    @Test
    fun decodePolymorphicHtmlFromString() {
        val data = Moshi.decodePolymorphicHtmlFromString(Resources.Minimised.polymorphicHtmlJsonString)
        assertTrue(data.isNotEmpty())
    }

    @Test
    fun encodePolymorphicHtmlToString() {
        val data = Moshi.decodePolymorphicHtmlFromString(Resources.Minimised.polymorphicHtmlJsonString)
        assertEquals(Resources.Minimised.polymorphicHtmlJsonString, Moshi.encodePolymorphicHtmlToString(data))
    }

    @Test
    fun decodeUserProfileFromString() {
        val data = Moshi.decodeUserProfileFromString(Resources.Minimised.userProfileJsonString)
        assertTrue(data.personal.firstName.isNotEmpty())
    }

    @Test
    fun encodeUserProfileToString() {
        val data = Moshi.decodeUserProfileFromString(Resources.Minimised.userProfileJsonString)
        assertEquals(Resources.Minimised.userProfileJsonString, Moshi.encodeUserProfileToString(data))
    }
}