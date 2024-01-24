package kmp.benchmarks.serialization.gson

import kmp.benchmarks.serialization.Resources

object Data {
    val largeList = Gson.decodeLargeListFromString(Resources.MinimisedJsonString.largeList)
    val largeListCompact = Gson.decodeLargeListCompactFromString(Resources.MinimisedJsonString.largeList)
    val macosReleases = Gson.decodeMacOsReleasesFromString(Resources.MinimisedJsonString.macosReleases)
    val polymorphicGeo = Gson.decodePolymorphicGeoFromString(Resources.MinimisedJsonString.polymorphicGeo)
    val polymorphicHtml = Gson.decodePolymorphicHtmlFromString(Resources.MinimisedJsonString.polymorphicHtml)
    val userProfile = Gson.decodeUserProfileFromString(Resources.MinimisedJsonString.userProfile)
}