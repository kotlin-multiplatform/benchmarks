plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.kotlinSerialization)
    alias(libs.plugins.ksp)
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
    macosArm64()

    sourceSets {
        commonMain.dependencies {
            api(libs.kotlinx.datetime)
            api(libs.kotlinx.serialization.core)
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
        jvmMain.dependencies {
            api(libs.gson)
            api(libs.moshi)
            api(libs.moshi.adapters)
        }
    }
}

android {
    namespace = "kmp.benchmarks.serialization.model"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
    }
}

dependencies {
    add("kspJvm", libs.moshi.kotlin.codegen.get())
}