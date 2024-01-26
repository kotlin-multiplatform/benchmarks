package kmp.benchmarks.serialization.gson

import kmp.benchmarks.serialization.JsonStrings
import kotlin.test.Test
import kotlin.test.assertEquals

class GsonPrettyPrintedEncodeTest {
//    @Test
//    fun encodeLargeListToString() {
//        assertEquals(
//            Resources.PrettyPrintedJsonString.largeList,
//            GsonPrettyPrinted.encodeLargeListToString(Data.largeList)
//        )
//    }
//
//    @Test
//    fun encodeLargeListCompactToString() {
//        assertEquals(
//            Resources.PrettyPrintedJsonString.largeList,
//            GsonPrettyPrinted.encodeLargeListCompactToString(Data.largeListCompact)
//        )
//    }

    @Test
    fun encodeMacOsReleasesToString() {
        assertEquals(
            JsonStrings.PrettyPrinted.macosReleases,
            GsonPrettyPrinted.encodeMacOsReleasesToString(JsonData.macosReleases)
        )
    }

    @Test
    fun encodePolymorphicGeoToString() {
        assertEquals(
            JsonStrings.PrettyPrinted.polymorphicGeo,
            GsonPrettyPrinted.encodePolymorphicGeoToString(JsonData.polymorphicGeo)
        )
    }

    @Test
    fun encodePolymorphicHtmlToString() {
        assertEquals(
            JsonStrings.PrettyPrinted.polymorphicHtml,
            GsonPrettyPrinted.encodePolymorphicHtmlToString(JsonData.polymorphicHtml)
        )
    }

    @Test
    fun encodeUserProfileToString() {
        assertEquals(
            JsonStrings.PrettyPrinted.userProfile,
            GsonPrettyPrinted.encodeUserProfileToString(JsonData.userProfile)
        )
    }
}