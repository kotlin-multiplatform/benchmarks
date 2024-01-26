package kmp.benchmarks.serialization.moshi

import kmp.benchmarks.serialization.JsonStrings
import kotlin.test.Test
import kotlin.test.assertEquals

class MoshiPrettyPrintedEncodeTest {
//    @Test
//    fun encodeLargeListToString() {
//        assertEquals(
//            Resources.PrettyPrintedJsonString.largeList,
//            MoshiPrettyPrinted.encodeLargeListToString(Data.largeList)
//        )
//    }
//
//    @Test
//    fun encodeLargeListCompactToString() {
//        assertEquals(
//            Resources.PrettyPrintedJsonString.largeList,
//            MoshiPrettyPrinted.encodeLargeListCompactToString(Data.largeListCompact)
//        )
//    }

    @Test
    fun encodeMacOsReleasesToString() {
        assertEquals(
            JsonStrings.PrettyPrinted.macosReleases,
            MoshiPrettyPrinted.encodeMacOsReleasesToString(JsonData.macosReleases)
        )
    }

    @Test
    fun encodePolymorphicGeoToString() {
        assertEquals(
            JsonStrings.PrettyPrinted.polymorphicGeo,
            MoshiPrettyPrinted.encodePolymorphicGeoToString(JsonData.polymorphicGeo)
        )
    }

    @Test
    fun encodePolymorphicHtmlToString() {
        assertEquals(
            JsonStrings.PrettyPrinted.polymorphicHtml,
            MoshiPrettyPrinted.encodePolymorphicHtmlToString(JsonData.polymorphicHtml)
        )
    }

    @Test
    fun encodeUserProfileToString() {
        assertEquals(
            JsonStrings.PrettyPrinted.userProfile,
            MoshiPrettyPrinted.encodeUserProfileToString(JsonData.userProfile)
        )
    }
}