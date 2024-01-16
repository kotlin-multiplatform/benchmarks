package kmp.benchmarks.serialization.moshi

import kmp.benchmarks.serialization.Resources
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class MoshiPrettyPrintedTest {
    @Test
    fun decodeLargeListFromString() {
        val data = MoshiPrettyPrinted.decodeLargeListFromString(Resources.PrettyPrinted.largeListJsonString)
        assertTrue(data.isNotEmpty())
    }

//    @Test
//    fun encodeLargeListToString() {
//        val data = MoshiPrettyPrinted.decodeLargeListFromString(Resources.PrettyPrinted.largeListJsonString)
//        assertEquals(Resources.PrettyPrinted.largeListJsonString, MoshiPrettyPrinted.encodeLargeListToString(data))
//    }

    @Test
    fun decodeMacOsReleasesFromString() {
        val data = MoshiPrettyPrinted.decodeMacOsReleasesFromString(Resources.PrettyPrinted.macosReleasesJsonString)
        assertTrue(data.versions.isNotEmpty())
    }

    @Test
    fun encodeMacOsReleasesToString() {
        val data = MoshiPrettyPrinted.decodeMacOsReleasesFromString(Resources.PrettyPrinted.macosReleasesJsonString)
        assertEquals(Resources.PrettyPrinted.macosReleasesJsonString, MoshiPrettyPrinted.encodeMacOsReleasesToString(data))
    }

    @Test
    fun decodePolymorphicGeoFromString() {
        val data = MoshiPrettyPrinted.decodePolymorphicGeoFromString(Resources.PrettyPrinted.polymorphicGeoJsonString)
        assertTrue(data.isNotEmpty())
    }

    @Test
    fun encodePolymorphicGeoToString() {
        val data = MoshiPrettyPrinted.decodePolymorphicGeoFromString(Resources.PrettyPrinted.polymorphicGeoJsonString)
        assertEquals(Resources.PrettyPrinted.polymorphicGeoJsonString, MoshiPrettyPrinted.encodePolymorphicGeoToString(data))
    }

    @Test
    fun decodePolymorphicHtmlFromString() {
        val data = MoshiPrettyPrinted.decodePolymorphicHtmlFromString(Resources.PrettyPrinted.polymorphicHtmlJsonString)
        assertTrue(data.isNotEmpty())
    }

    @Test
    fun encodePolymorphicHtmlToString() {
        val data = MoshiPrettyPrinted.decodePolymorphicHtmlFromString(Resources.PrettyPrinted.polymorphicHtmlJsonString)
        assertEquals(Resources.PrettyPrinted.polymorphicHtmlJsonString, MoshiPrettyPrinted.encodePolymorphicHtmlToString(data))
    }

    @Test
    fun decodeUserProfileFromString() {
        val data = MoshiPrettyPrinted.decodeUserProfileFromString(Resources.PrettyPrinted.userProfileJsonString)
        assertTrue(data.personal.firstName.isNotEmpty())
    }

    @Test
    fun encodeUserProfileToString() {
        val data = MoshiPrettyPrinted.decodeUserProfileFromString(Resources.PrettyPrinted.userProfileJsonString)
        assertEquals(Resources.PrettyPrinted.userProfileJsonString, MoshiPrettyPrinted.encodeUserProfileToString(data))
    }
}