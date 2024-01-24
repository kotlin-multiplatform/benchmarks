package kmp.benchmarks.serialization.moshi

import kmp.benchmarks.serialization.Resources
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
            Resources.MinimisedJsonString.macosReleases,
            Moshi.encodeMacOsReleasesToString(Data.macosReleases)
        )
    }

    @Test
    fun encodePolymorphicGeoToString() {
        assertEquals(
            Resources.MinimisedJsonString.polymorphicGeo,
            Moshi.encodePolymorphicGeoToString(Data.polymorphicGeo)
        )
    }

    @Test
    fun encodePolymorphicHtmlToString() {
        assertEquals(
            Resources.MinimisedJsonString.polymorphicHtml,
            Moshi.encodePolymorphicHtmlToString(Data.polymorphicHtml)
        )
    }

    @Test
    fun encodeUserProfileToString() {
        assertEquals(
            Resources.MinimisedJsonString.userProfile,
            Moshi.encodeUserProfileToString(Data.userProfile)
        )
    }
}