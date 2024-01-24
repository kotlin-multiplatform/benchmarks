package kmp.benchmarks.serialization.moshi

import kmp.benchmarks.serialization.Resources

object Data {
    val largeList = Moshi.decodeLargeListFromString(Resources.MinimisedJsonString.largeList)
    val largeListCompact = Moshi.decodeLargeListCompactFromString(Resources.MinimisedJsonString.largeList)
    val macosReleases = Moshi.decodeMacOsReleasesFromString(Resources.MinimisedJsonString.macosReleases)
    val polymorphicGeo = Moshi.decodePolymorphicGeoFromString(Resources.MinimisedJsonString.polymorphicGeo)
    val polymorphicHtml = Moshi.decodePolymorphicHtmlFromString(Resources.MinimisedJsonString.polymorphicHtml)
    val userProfile = Moshi.decodeUserProfileFromString(Resources.MinimisedJsonString.userProfile)
}