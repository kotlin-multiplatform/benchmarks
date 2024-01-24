package kmp.benchmarks.serialization.kotlinxserialization

import kmp.benchmarks.serialization.Resources

object Data {
    val largeList = KotlinxSerialization.decodeLargeListFromString(Resources.MinimisedJsonString.largeList)
    val largeListCompact = KotlinxSerialization.decodeLargeListCompactFromString(Resources.MinimisedJsonString.largeList)
    val macosReleases = KotlinxSerialization.decodeMacOsReleasesFromString(Resources.MinimisedJsonString.macosReleases)
    val polymorphicGeo = KotlinxSerialization.decodePolymorphicGeoFromString(Resources.MinimisedJsonString.polymorphicGeo)
    val polymorphicHtml = KotlinxSerialization.decodePolymorphicHtmlFromString(Resources.MinimisedJsonString.polymorphicHtml)
    val userProfile = KotlinxSerialization.decodeUserProfileFromString(Resources.MinimisedJsonString.userProfile)
}