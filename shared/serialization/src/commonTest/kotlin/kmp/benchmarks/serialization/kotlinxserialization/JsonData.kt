package kmp.benchmarks.serialization.kotlinxserialization

import kmp.benchmarks.serialization.JsonStrings

object JsonData {
    val largeList = KotlinxSerialization.decodeLargeListFromString(JsonStrings.Minimised.largeList)
    val largeListCompact = KotlinxSerialization.decodeLargeListCompactFromString(JsonStrings.Minimised.largeList)
    val macosReleases = KotlinxSerialization.decodeMacOsReleasesFromString(JsonStrings.Minimised.macosReleases)
    val polymorphicGeo = KotlinxSerialization.decodePolymorphicGeoFromString(JsonStrings.Minimised.polymorphicGeo)
    val polymorphicHtml = KotlinxSerialization.decodePolymorphicHtmlFromString(JsonStrings.Minimised.polymorphicHtml)
    val userProfile = KotlinxSerialization.decodeUserProfileFromString(JsonStrings.Minimised.userProfile)
}