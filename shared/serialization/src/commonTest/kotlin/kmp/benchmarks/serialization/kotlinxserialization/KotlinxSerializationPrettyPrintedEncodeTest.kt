package kmp.benchmarks.serialization.kotlinxserialization

import kmp.benchmarks.serialization.Resources
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
            Resources.PrettyPrintedJsonString.macosReleases,
            KotlinxSerializationPrettyPrinted.encodeMacOsReleasesToString(Data.macosReleases)
        )
    }

    @Test
    fun encodePolymorphicGeoToString() {
        assertEquals(
            Resources.PrettyPrintedJsonString.polymorphicGeo,
            KotlinxSerializationPrettyPrinted.encodePolymorphicGeoToString(Data.polymorphicGeo)
        )
    }

    @Test
    fun encodePolymorphicHtmlToString() {
        assertEquals(
            Resources.PrettyPrintedJsonString.polymorphicHtml,
            KotlinxSerializationPrettyPrinted.encodePolymorphicHtmlToString(Data.polymorphicHtml)
        )
    }

    @Test
    fun encodeUserProfileToString() {
        assertEquals(
            Resources.PrettyPrintedJsonString.userProfile,
            KotlinxSerializationPrettyPrinted.encodeUserProfileToString(Data.userProfile)
        )
    }
}