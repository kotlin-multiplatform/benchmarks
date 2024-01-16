package kmp.benchmarks.serialization

import com.goncalossilva.resources.Resource

object Resources {
    object Minimised {
        val largeListJsonString = Resource("src/commonTest/resources/large-list-min.json").readText()
        val macosReleasesJsonString = Resource("src/commonTest/resources/macos-releases-min.json").readText()
        val polymorphicGeoJsonString = Resource("src/commonTest/resources/polymorphic-geo-min.json").readText()
        val polymorphicHtmlJsonString = Resource("src/commonTest/resources/polymorphic-html-min.json").readText()
        val userProfileJsonString = Resource("src/commonTest/resources/user-profile-min.json").readText()
    }

    object PrettyPrinted {
        val largeListJsonString = Resource("src/commonTest/resources/large-list.json").readText()
        val macosReleasesJsonString = Resource("src/commonTest/resources/macos-releases.json").readText()
        val polymorphicGeoJsonString = Resource("src/commonTest/resources/polymorphic-geo.json").readText()
        val polymorphicHtmlJsonString = Resource("src/commonTest/resources/polymorphic-html.json").readText()
        val userProfileJsonString = Resource("src/commonTest/resources/user-profile.json").readText()
    }
}