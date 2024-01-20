package kmp.benchmarks.serialization.kotlinxserialization

import kmp.benchmarks.serialization.Resources
import kotlin.test.Test
import kotlin.test.assertEquals

class KotlinxSerializationEncodeTest {
//    @Test
//    fun encodeLargeListToString() {
//        val data = KotlinxSerialization.decodeLargeListFromString(Resources.Minimised.largeListJsonString)
//        assertEquals(Resources.Minimised.largeListJsonString, KotlinxSerialization.encodeLargeListToString(data))
//    }

//    @Test
//    fun encodeLargeListCompactToString() {
//        val data = KotlinxSerialization.decodeLargeListCompactFromString(Resources.Minimised.largeListJsonString)
//        assertEquals(Resources.Minimised.largeListJsonString, KotlinxSerialization.encodeLargeListCompactToString(data))
//    }

    @Test
    fun encodeMacOsReleasesToString() {
        val data = KotlinxSerialization.decodeMacOsReleasesFromString(Resources.Minimised.macosReleasesJsonString)
        assertEquals(Resources.Minimised.macosReleasesJsonString, KotlinxSerialization.encodeMacOsReleasesToString(data))
    }

    @Test
    fun encodePolymorphicGeoToString() {
        val data = KotlinxSerialization.decodePolymorphicGeoFromString(Resources.Minimised.polymorphicGeoJsonString)
        assertEquals(Resources.Minimised.polymorphicGeoJsonString, KotlinxSerialization.encodePolymorphicGeoToString(data))
    }

    @Test
    fun encodePolymorphicHtmlToString() {
        val data = KotlinxSerialization.decodePolymorphicHtmlFromString(Resources.Minimised.polymorphicHtmlJsonString)
        assertEquals(Resources.Minimised.polymorphicHtmlJsonString, KotlinxSerialization.encodePolymorphicHtmlToString(data))
    }

    @Test
    fun encodeUserProfileToString() {
        val data = KotlinxSerialization.decodeUserProfileFromString(Resources.Minimised.userProfileJsonString)
        assertEquals(Resources.Minimised.userProfileJsonString, KotlinxSerialization.encodeUserProfileToString(data))
    }
}