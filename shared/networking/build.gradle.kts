plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.goncalossilvaResources)
    alias(libs.plugins.kotlinMultiplatform)
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

//    iosX64()
    iosArm64()
    iosSimulatorArm64()

//    macosX64()
//    macosArm64()

    sourceSets {
        commonMain.dependencies {
            implementation(libs.kmp.common.ktor)
            implementation(libs.ktor.client.content.negotiation)
            implementation(libs.ktor.client.logging)
            implementation(libs.ktor.serialization.kotlinx.json)
            implementation(libs.kotlinx.datetime)
            implementation(libs.kotlinx.serialization.json)
            implementation(projects.shared.serialization)
        }
        commonTest.dependencies {
            implementation(libs.goncalossilva.resources)
            implementation(libs.kotlin.test)
            implementation(libs.ktor.client.mock)
        }
        jvmMain.dependencies {
            implementation(libs.logback.classic)
            implementation(libs.okhttp.logging)
            implementation(libs.retrofit)
            implementation(libs.retrofit.gson)
            implementation(libs.retrofit.kotlinx.serialization)
            implementation(libs.retrofit.moshi)
        }
        jvmTest.dependencies {
            implementation(libs.okhttp.mockwebserver)
        }
    }
}

android {
    namespace = "kmp.benchmarks.networking"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}
