package kmp.benchmarks.serialization.gson

import kmp.benchmarks.serialization.Resources
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class GsonEncodeTest {
//    @Test
//    fun encodeLargeListToString() {
//        val data = Gson.decodeLargeListFromString(Resources.Minimised.largeListJsonString)
//        assertEquals(Resources.Minimised.largeListJsonString, Gson.encodeLargeListToString(data))
//    }

//    @Test
//    fun encodeLargeListCompactToString() {
//        val data = Gson.decodeLargeListCompactFromString(Resources.Minimised.largeListJsonString)
//        assertEquals(Resources.Minimised.largeListJsonString, Gson.encodeLargeListCompactToString(data))
//    }

    @Test
    fun encodeMacOsReleasesToString() {
        val data = Gson.decodeMacOsReleasesFromString(Resources.Minimised.macosReleasesJsonString)
        assertEquals(Resources.Minimised.macosReleasesJsonString, Gson.encodeMacOsReleasesToString(data))
    }

    @Test
    fun encodePolymorphicGeoToString() {
        val data = Gson.decodePolymorphicGeoFromString(Resources.Minimised.polymorphicGeoJsonString)
        assertEquals(Resources.Minimised.polymorphicGeoJsonString, Gson.encodePolymorphicGeoToString(data))
    }

    @Test
    fun encodePolymorphicHtmlToString() {
        val data = Gson.decodePolymorphicHtmlFromString(Resources.Minimised.polymorphicHtmlJsonString)
        assertEquals(Resources.Minimised.polymorphicHtmlJsonString, Gson.encodePolymorphicHtmlToString(data))
    }

    @Test
    fun encodeUserProfileToString() {
        val data = Gson.decodeUserProfileFromString(Resources.Minimised.userProfileJsonString)
        assertEquals(Resources.Minimised.userProfileJsonString, Gson.encodeUserProfileToString(data))
    }
}