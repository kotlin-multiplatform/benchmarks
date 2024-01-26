package kmp.benchmarks.serialization.moshi

import kmp.benchmarks.serialization.JsonStrings
import kotlin.test.Test
import kotlin.test.assertEquals

class MoshiEncodeTest {
//    @Test
//    fun encodeLargeListToString() {
//        assertEquals(
//            Resources.MinimisedJsonString.largeList,
//            Moshi.encodeLargeListToString(Data.largeList)
//        )
//    }
//
//    @Test
//    fun encodeLargeListCompactToString() {
//        assertEquals(
//            Resources.MinimisedJsonString.largeList,
//            Moshi.encodeLargeListCompactToString(Data.largeListCompact)
//        )
//    }

    @Test
    fun encodeMacOsReleasesToString() {
        assertEquals(
            JsonStrings.Minimised.macosReleases,
            Moshi.encodeMacOsReleasesToString(JsonData.macosReleases)
        )
    }

    @Test
    fun encodePolymorphicGeoToString() {
        assertEquals(
            JsonStrings.Minimised.polymorphicGeo,
            Moshi.encodePolymorphicGeoToString(JsonData.polymorphicGeo)
        )
    }

    @Test
    fun encodePolymorphicHtmlToString() {
        assertEquals(
            JsonStrings.Minimised.polymorphicHtml,
            Moshi.encodePolymorphicHtmlToString(JsonData.polymorphicHtml)
        )
    }

    @Test
    fun encodeUserProfileToString() {
        assertEquals(
            JsonStrings.Minimised.userProfile,
            Moshi.encodeUserProfileToString(JsonData.userProfile)
        )
    }
}