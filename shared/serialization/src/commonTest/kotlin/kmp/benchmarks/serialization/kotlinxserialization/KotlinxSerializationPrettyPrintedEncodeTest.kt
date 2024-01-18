package kmp.benchmarks.serialization.kotlinxserialization

import kmp.benchmarks.serialization.Resources
import kotlin.test.Test
import kotlin.test.assertEquals

class KotlinxSerializationPrettyPrintedEncodeTest {
//    @Test
//    fun encodeLargeListToString() {
//        val data = KotlinxSerializationPrettyPrinted.decodeLargeListFromString(Resources.PrettyPrinted.largeListJsonString)
//        assertEquals(Resources.PrettyPrinted.largeListJsonString, KotlinxSerializationPrettyPrinted.encodeLargeListToString(data))
//    }

//    @Test
//    fun encodeLargeListCompactToString() {
//        val data = KotlinxSerialization.decodeLargeListCompactFromString(Resources.PrettyPrinted.largeListJsonString)
//        assertEquals(Resources.PrettyPrinted.largeListJsonString, KotlinxSerialization.encodeLargeListCompactToString(data))
//    }

    @Test
    fun encodeMacOsReleasesToString() {
        val data = KotlinxSerializationPrettyPrinted.decodeMacOsReleasesFromString(Resources.PrettyPrinted.macosReleasesJsonString)
        assertEquals(Resources.PrettyPrinted.macosReleasesJsonString, KotlinxSerializationPrettyPrinted.encodeMacOsReleasesToString(data))
    }

    @Test
    fun encodePolymorphicGeoToString() {
        val data = KotlinxSerializationPrettyPrinted.decodePolymorphicGeoFromString(Resources.PrettyPrinted.polymorphicGeoJsonString)
        assertEquals(Resources.PrettyPrinted.polymorphicGeoJsonString, KotlinxSerializationPrettyPrinted.encodePolymorphicGeoToString(data))
    }

    @Test
    fun encodePolymorphicHtmlToString() {
        val data = KotlinxSerializationPrettyPrinted.decodePolymorphicHtmlFromString(Resources.PrettyPrinted.polymorphicHtmlJsonString)
        assertEquals(Resources.PrettyPrinted.polymorphicHtmlJsonString, KotlinxSerializationPrettyPrinted.encodePolymorphicHtmlToString(data))
    }

    @Test
    fun encodeUserProfileToString() {
        val data = KotlinxSerializationPrettyPrinted.decodeUserProfileFromString(Resources.PrettyPrinted.userProfileJsonString)
        assertEquals(Resources.PrettyPrinted.userProfileJsonString, KotlinxSerializationPrettyPrinted.encodeUserProfileToString(data))
    }
}