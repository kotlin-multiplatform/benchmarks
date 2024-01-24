package kmp.benchmarks.serialization.kotlinxserialization

import kmp.benchmarks.serialization.Resources
import kotlin.test.Test
import kotlin.test.assertEquals

class KotlinxSerializationEncodeTest {
//    @Test
//    fun encodeLargeListToString() {
//        assertEquals(
//            Resources.MinimisedJsonString.largeList,
//            KotlinxSerialization.encodeLargeListToString(Data.largeList)
//        )
//    }
//
//    @Test
//    fun encodeLargeListCompactToString() {
//        assertEquals(
//            Resources.MinimisedJsonString.largeList,
//            KotlinxSerialization.encodeLargeListCompactToString(Data.largeListCompact)
//        )
//    }

    @Test
    fun encodeMacOsReleasesToString() {
        assertEquals(
            Resources.MinimisedJsonString.macosReleases,
            KotlinxSerialization.encodeMacOsReleasesToString(Data.macosReleases)
        )
    }

    @Test
    fun encodePolymorphicGeoToString() {
        assertEquals(
            Resources.MinimisedJsonString.polymorphicGeo,
            KotlinxSerialization.encodePolymorphicGeoToString(Data.polymorphicGeo)
        )
    }

    @Test
    fun encodePolymorphicHtmlToString() {
        assertEquals(
            Resources.MinimisedJsonString.polymorphicHtml,
            KotlinxSerialization.encodePolymorphicHtmlToString(Data.polymorphicHtml)
        )
    }

    @Test
    fun encodeUserProfileToString() {
        assertEquals(
            Resources.MinimisedJsonString.userProfile,
            KotlinxSerialization.encodeUserProfileToString(Data.userProfile)
        )
    }
}