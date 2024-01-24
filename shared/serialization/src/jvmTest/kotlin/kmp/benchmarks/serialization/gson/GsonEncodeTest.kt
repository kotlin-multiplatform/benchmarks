package kmp.benchmarks.serialization.gson

import kmp.benchmarks.serialization.Resources
import kotlin.test.Test
import kotlin.test.assertEquals

class GsonEncodeTest {
//    @Test
//    fun encodeLargeListToString() {
//        assertEquals(
//            Resources.MinimisedJsonString.largeList,
//            Gson.encodeLargeListToString(Data.largeList)
//        )
//    }
//
//    @Test
//    fun encodeLargeListCompactToString() {
//        assertEquals(
//            Resources.MinimisedJsonString.largeList,
//            Gson.encodeLargeListCompactToString(Data.largeListCompact)
//        )
//    }

    @Test
    fun encodeMacOsReleasesToString() {
        assertEquals(
            Resources.MinimisedJsonString.macosReleases,
            Gson.encodeMacOsReleasesToString(Data.macosReleases)
        )
    }

    @Test
    fun encodePolymorphicGeoToString() {
        assertEquals(
            Resources.MinimisedJsonString.polymorphicGeo,
            Gson.encodePolymorphicGeoToString(Data.polymorphicGeo)
        )
    }

    @Test
    fun encodePolymorphicHtmlToString() {
        assertEquals(
            Resources.MinimisedJsonString.polymorphicHtml,
            Gson.encodePolymorphicHtmlToString(Data.polymorphicHtml)
        )
    }

    @Test
    fun encodeUserProfileToString() {
        assertEquals(
            Resources.MinimisedJsonString.userProfile,
            Gson.encodeUserProfileToString(Data.userProfile)
        )
    }
}