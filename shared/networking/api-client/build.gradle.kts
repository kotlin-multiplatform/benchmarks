plugins {
    alias(libs.plugins.androidLibrary)
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

    iosX64()
    iosArm64()
    iosSimulatorArm64()

    sourceSets {
        commonMain.dependencies {
            api(libs.ktor.client.core)
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
        androidMain.dependencies {
            api(libs.ktor.client.okhttp)
        }
        jvmMain.dependencies {
            api(libs.ktor.client.cio)
        }
        appleMain.dependencies {
            api(libs.ktor.client.darwin)
        }
    }
}

android {
    namespace = "kmp.benchmarks.networking.apiclient"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
    }
}
