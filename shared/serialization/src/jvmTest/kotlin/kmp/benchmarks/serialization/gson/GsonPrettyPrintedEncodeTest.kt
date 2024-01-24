package kmp.benchmarks.serialization.gson

import kmp.benchmarks.serialization.Resources
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
            Resources.PrettyPrintedJsonString.macosReleases,
            GsonPrettyPrinted.encodeMacOsReleasesToString(Data.macosReleases)
        )
    }

    @Test
    fun encodePolymorphicGeoToString() {
        assertEquals(
            Resources.PrettyPrintedJsonString.polymorphicGeo,
            GsonPrettyPrinted.encodePolymorphicGeoToString(Data.polymorphicGeo)
        )
    }

    @Test
    fun encodePolymorphicHtmlToString() {
        assertEquals(
            Resources.PrettyPrintedJsonString.polymorphicHtml,
            GsonPrettyPrinted.encodePolymorphicHtmlToString(Data.polymorphicHtml)
        )
    }

    @Test
    fun encodeUserProfileToString() {
        assertEquals(
            Resources.PrettyPrintedJsonString.userProfile,
            GsonPrettyPrinted.encodeUserProfileToString(Data.userProfile)
        )
    }
}