package kmp.benchmarks.serialization.gson

import kmp.benchmarks.serialization.Resources
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class GsonTest {
    @Test
    fun decodeLargeListFromString() {
        val data = Gson.decodeLargeListFromString(Resources.Minimised.largeListJsonString)
        assertTrue(data.isNotEmpty())
    }

//    @Test
//    fun encodeLargeListToString() {
//        val data = Gson.decodeLargeListFromString(Resources.Minimised.largeListJsonString)
//        assertEquals(Resources.Minimised.largeListJsonString, Gson.encodeLargeListToString(data))
//    }

    @Test
    fun decodeMacOsReleasesFromString() {
        val data = Gson.decodeMacOsReleasesFromString(Resources.Minimised.macosReleasesJsonString)
        assertTrue(data.versions.isNotEmpty())
    }

    @Test
    fun encodeMacOsReleasesToString() {
        val data = Gson.decodeMacOsReleasesFromString(Resources.Minimised.macosReleasesJsonString)
        assertEquals(Resources.Minimised.macosReleasesJsonString, Gson.encodeMacOsReleasesToString(data))
    }

    @Test
    fun decodePolymorphicGeoFromString() {
        val data = Gson.decodePolymorphicGeoFromString(Resources.Minimised.polymorphicGeoJsonString)
        assertTrue(data.isNotEmpty())
    }

    @Test
    fun encodePolymorphicGeoToString() {
        val data = Gson.decodePolymorphicGeoFromString(Resources.Minimised.polymorphicGeoJsonString)
        assertEquals(Resources.Minimised.polymorphicGeoJsonString, Gson.encodePolymorphicGeoToString(data))
    }

    @Test
    fun decodePolymorphicHtmlFromString() {
        val data = Gson.decodePolymorphicHtmlFromString(Resources.Minimised.polymorphicHtmlJsonString)
        assertTrue(data.isNotEmpty())
    }

    @Test
    fun encodePolymorphicHtmlToString() {
        val data = Gson.decodePolymorphicHtmlFromString(Resources.Minimised.polymorphicHtmlJsonString)
        assertEquals(Resources.Minimised.polymorphicHtmlJsonString, Gson.encodePolymorphicHtmlToString(data))
    }

    @Test
    fun decodeUserProfileFromString() {
        val data = Gson.decodeUserProfileFromString(Resources.Minimised.userProfileJsonString)
        assertTrue(data.personal.firstName.isNotEmpty())
    }

    @Test
    fun encodeUserProfileToString() {
        val data = Gson.decodeUserProfileFromString(Resources.Minimised.userProfileJsonString)
        assertEquals(Resources.Minimised.userProfileJsonString, Gson.encodeUserProfileToString(data))
    }
}