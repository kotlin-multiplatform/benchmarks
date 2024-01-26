package kmp.benchmarks.serialization.gson

import kmp.benchmarks.serialization.JsonStrings

object JsonData {
    val largeList = Gson.decodeLargeListFromString(JsonStrings.Minimised.largeList)
    val largeListCompact = Gson.decodeLargeListCompactFromString(JsonStrings.Minimised.largeList)
    val macosReleases = Gson.decodeMacOsReleasesFromString(JsonStrings.Minimised.macosReleases)
    val polymorphicGeo = Gson.decodePolymorphicGeoFromString(JsonStrings.Minimised.polymorphicGeo)
    val polymorphicHtml = Gson.decodePolymorphicHtmlFromString(JsonStrings.Minimised.polymorphicHtml)
    val userProfile = Gson.decodeUserProfileFromString(JsonStrings.Minimised.userProfile)
}