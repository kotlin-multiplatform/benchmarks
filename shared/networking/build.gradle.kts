plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.goncalossilvaResources)
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.kotlinxSerialization)
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }

    jvm()

    iosX64()
    iosArm64()
    iosSimulatorArm64()

    sourceSets {
        commonMain.dependencies {
            implementation(libs.ktor.client.content.negotiation)
            implementation(libs.ktor.client.logging)
            implementation(libs.ktor.serialization.kotlinx.json)
            implementation(libs.kotlinx.datetime)
            implementation(libs.kotlinx.serialization.core)
            implementation(libs.kotlinx.serialization.json)
            implementation(projects.shared.networking.apiClient)
            implementation(projects.shared.serialization.model)
        }
        commonTest.dependencies {
            implementation(libs.goncalossilva.resources)
            implementation(libs.kotlin.test)
            implementation(libs.ktor.client.mock)
        }
        jvmMain.dependencies {
            implementation(libs.logback.classic)
        }
    }
}

android {
    namespace = "kmp.benchmarks.networking"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
    }
}
