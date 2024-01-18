package kmp.benchmarks.serialization.moshi

import kmp.benchmarks.serialization.Resources
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class MoshiPrettyPrintedEncodeTest {
//    @Test
//    fun encodeLargeListToString() {
//        val data = MoshiPrettyPrinted.decodeLargeListFromString(Resources.PrettyPrinted.largeListJsonString)
//        assertEquals(Resources.PrettyPrinted.largeListJsonString, MoshiPrettyPrinted.encodeLargeListToString(data))
//    }

//    @Test
//    fun encodeLargeListCompactToString() {
//        val data = MoshiPrettyPrinted.decodeLargeListCompactFromString(Resources.PrettyPrinted.largeListJsonString)
//        assertEquals(Resources.PrettyPrinted.largeListJsonString, MoshiPrettyPrinted.encodeLargeListCompactToString(data))
//    }

    @Test
    fun encodeMacOsReleasesToString() {
        val data = MoshiPrettyPrinted.decodeMacOsReleasesFromString(Resources.PrettyPrinted.macosReleasesJsonString)
        assertEquals(Resources.PrettyPrinted.macosReleasesJsonString, MoshiPrettyPrinted.encodeMacOsReleasesToString(data))
    }

    @Test
    fun encodePolymorphicGeoToString() {
        val data = MoshiPrettyPrinted.decodePolymorphicGeoFromString(Resources.PrettyPrinted.polymorphicGeoJsonString)
        assertEquals(Resources.PrettyPrinted.polymorphicGeoJsonString, MoshiPrettyPrinted.encodePolymorphicGeoToString(data))
    }

    @Test
    fun encodePolymorphicHtmlToString() {
        val data = MoshiPrettyPrinted.decodePolymorphicHtmlFromString(Resources.PrettyPrinted.polymorphicHtmlJsonString)
        assertEquals(Resources.PrettyPrinted.polymorphicHtmlJsonString, MoshiPrettyPrinted.encodePolymorphicHtmlToString(data))
    }

    @Test
    fun encodeUserProfileToString() {
        val data = MoshiPrettyPrinted.decodeUserProfileFromString(Resources.PrettyPrinted.userProfileJsonString)
        assertEquals(Resources.PrettyPrinted.userProfileJsonString, MoshiPrettyPrinted.encodeUserProfileToString(data))
    }
}