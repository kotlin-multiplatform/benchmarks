package kmp.benchmarks.serialization.gson

import kmp.benchmarks.serialization.Resources
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class GsonPrettyPrintedEncodeTest {
//    @Test
//    fun encodeLargeListToString() {
//        val data = GsonPrettyPrinted.decodeLargeListFromString(Resources.PrettyPrinted.largeListJsonString)
//        assertEquals(Resources.PrettyPrinted.largeListJsonString, GsonPrettyPrinted.encodeLargeListToString(data))
//    }

//    @Test
//    fun encodeLargeListCompactToString() {
//        val data = GsonPrettyPrinted.decodeLargeListCompactFromString(Resources.PrettyPrinted.largeListJsonString)
//        assertEquals(Resources.PrettyPrinted.largeListJsonString, GsonPrettyPrinted.encodeLargeListCompactToString(data))
//    }

    @Test
    fun encodeMacOsReleasesToString() {
        val data = GsonPrettyPrinted.decodeMacOsReleasesFromString(Resources.PrettyPrinted.macosReleasesJsonString)
        assertEquals(Resources.PrettyPrinted.macosReleasesJsonString, GsonPrettyPrinted.encodeMacOsReleasesToString(data))
    }

    @Test
    fun encodePolymorphicGeoToString() {
        val data = GsonPrettyPrinted.decodePolymorphicGeoFromString(Resources.PrettyPrinted.polymorphicGeoJsonString)
        assertEquals(Resources.PrettyPrinted.polymorphicGeoJsonString, GsonPrettyPrinted.encodePolymorphicGeoToString(data))
    }

    @Test
    fun encodePolymorphicHtmlToString() {
        val data = GsonPrettyPrinted.decodePolymorphicHtmlFromString(Resources.PrettyPrinted.polymorphicHtmlJsonString)
        assertEquals(Resources.PrettyPrinted.polymorphicHtmlJsonString, GsonPrettyPrinted.encodePolymorphicHtmlToString(data))
    }

    @Test
    fun encodeUserProfileToString() {
        val data = GsonPrettyPrinted.decodeUserProfileFromString(Resources.PrettyPrinted.userProfileJsonString)
        assertEquals(Resources.PrettyPrinted.userProfileJsonString, GsonPrettyPrinted.encodeUserProfileToString(data))
    }
}