package kmp.benchmarks.serialization.kotlinxserialization

import kmp.benchmarks.serialization.JsonStrings
import kmp.benchmarks.serialization.model.kotlinxserialization.UserProfile
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
            JsonStrings.Minimised.macosReleases,
            KotlinxSerialization.encodeMacOsReleasesToString(JsonData.macosReleases)
        )
    }

    @Test
    fun encodePolymorphicGeoToString() {
        assertEquals(
            JsonStrings.Minimised.polymorphicGeo,
            KotlinxSerialization.encodePolymorphicGeoToString(JsonData.polymorphicGeo)
        )
    }

    @Test
    fun encodePolymorphicHtmlToString() {
        assertEquals(
            JsonStrings.Minimised.polymorphicHtml,
            KotlinxSerialization.encodePolymorphicHtmlToString(JsonData.polymorphicHtml)
        )
    }

    @Test
    fun encodeUserProfileToString() {
        assertEquals(
            JsonStrings.Minimised.userProfile,
            KotlinxSerialization.encodeUserProfileToString(JsonData.userProfile)
        )

        assertEquals(
            FakeData.UserProfile.jsonString,
            KotlinxSerialization.encodeUserProfileToString(FakeData.UserProfile.data)
        )
    }
}