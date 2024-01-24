package kmp.benchmarks.serialization

import com.goncalossilva.resources.Resource

object Resources {
    object MinimisedJsonString {
        val largeList = Resource("src/commonTest/resources/large-list-min.json").readText()
        val macosReleases = Resource("src/commonTest/resources/macos-releases-min.json").readText()
        val polymorphicGeo = Resource("src/commonTest/resources/polymorphic-geo-min.json").readText()
        val polymorphicHtml = Resource("src/commonTest/resources/polymorphic-html-min.json").readText()
        val userProfile = Resource("src/commonTest/resources/user-profile-min.json").readText()
    }

    object PrettyPrintedJsonString {
        val largeList = Resource("src/commonTest/resources/large-list.json").readText()
        val macosReleases = Resource("src/commonTest/resources/macos-releases.json").readText()
        val polymorphicGeo = Resource("src/commonTest/resources/polymorphic-geo.json").readText()
        val polymorphicHtml = Resource("src/commonTest/resources/polymorphic-html.json").readText()
        val userProfile = Resource("src/commonTest/resources/user-profile.json").readText()
    }
}