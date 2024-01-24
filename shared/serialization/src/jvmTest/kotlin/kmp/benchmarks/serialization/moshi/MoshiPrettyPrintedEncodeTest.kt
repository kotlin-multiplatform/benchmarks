package kmp.benchmarks.serialization.moshi

import kmp.benchmarks.serialization.Resources
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
            Resources.PrettyPrintedJsonString.macosReleases,
            MoshiPrettyPrinted.encodeMacOsReleasesToString(Data.macosReleases)
        )
    }

    @Test
    fun encodePolymorphicGeoToString() {
        assertEquals(
            Resources.PrettyPrintedJsonString.polymorphicGeo,
            MoshiPrettyPrinted.encodePolymorphicGeoToString(Data.polymorphicGeo)
        )
    }

    @Test
    fun encodePolymorphicHtmlToString() {
        assertEquals(
            Resources.PrettyPrintedJsonString.polymorphicHtml,
            MoshiPrettyPrinted.encodePolymorphicHtmlToString(Data.polymorphicHtml)
        )
    }

    @Test
    fun encodeUserProfileToString() {
        assertEquals(
            Resources.PrettyPrintedJsonString.userProfile,
            MoshiPrettyPrinted.encodeUserProfileToString(Data.userProfile)
        )
    }
}