enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "kotlin-multiplatform-benchmarks"
include(":app-android")
include(":app-shared")
include(":shared:networking")
include(":shared:networking:ktor-http-client")
include(":shared:serialization")
//include(":shared:serialization:benchmarks")
include(":shared:serialization:model")