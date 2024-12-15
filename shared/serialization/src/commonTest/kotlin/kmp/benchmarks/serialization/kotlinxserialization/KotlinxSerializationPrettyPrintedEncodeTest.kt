package kmp.benchmarks.serialization.kotlinxserialization

import kmp.benchmarks.serialization.JsonStrings
import kotlin.test.Test
import kotlin.test.assertEquals

class KotlinxSerializationPrettyPrintedEncodeTest {
//    @Test
//    fun encodeLargeListToString() {
//        assertEquals(
//            Resources.PrettyPrintedJsonString.largeList,
//            KotlinxSerializationPrettyPrinted.encodeLargeListToString(Data.largeList)
//        )
//    }
//
//    @Test
//    fun encodeLargeListCompactToString() {
//        assertEquals(
//            Resources.PrettyPrintedJsonString.largeList,
//            KotlinxSerializationPrettyPrinted.encodeLargeListCompactToString(Data.largeListCompact)
//        )
//    }

    @Test
    fun encodeMacOsReleasesToString() {
        assertEquals(
            JsonStrings.PrettyPrinted.macosReleases,
            KotlinxSerializationPrettyPrinted.encodeMacOsReleasesToString(JsonData.macosReleases)
        )
    }

    @Test
    fun encodePolymorphicGeoToString() {
        assertEquals(
            JsonStrings.PrettyPrinted.polymorphicGeo,
            KotlinxSerializationPrettyPrinted.encodePolymorphicGeoToString(JsonData.polymorphicGeo)
        )
    }

    @Test
    fun encodePolymorphicHtmlToString() {
        assertEquals(
            JsonStrings.PrettyPrinted.polymorphicHtml,
            KotlinxSerializationPrettyPrinted.encodePolymorphicHtmlToString(JsonData.polymorphicHtml)
        )
    }

    @Test
    fun encodeUserProfileToString() {
        assertEquals(
            JsonStrings.PrettyPrinted.userProfile,
            KotlinxSerializationPrettyPrinted.encodeUserProfileToString(JsonData.userProfile)
        )
    }
}