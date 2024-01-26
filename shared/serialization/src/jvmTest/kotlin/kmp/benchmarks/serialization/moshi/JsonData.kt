package kmp.benchmarks.serialization.moshi

import kmp.benchmarks.serialization.JsonStrings

object JsonData {
    val largeList = Moshi.decodeLargeListFromString(JsonStrings.Minimised.largeList)
    val largeListCompact = Moshi.decodeLargeListCompactFromString(JsonStrings.Minimised.largeList)
    val macosReleases = Moshi.decodeMacOsReleasesFromString(JsonStrings.Minimised.macosReleases)
    val polymorphicGeo = Moshi.decodePolymorphicGeoFromString(JsonStrings.Minimised.polymorphicGeo)
    val polymorphicHtml = Moshi.decodePolymorphicHtmlFromString(JsonStrings.Minimised.polymorphicHtml)
    val userProfile = Moshi.decodeUserProfileFromString(JsonStrings.Minimised.userProfile)
}