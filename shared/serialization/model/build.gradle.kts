import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.kotlinSerialization)
    alias(libs.plugins.ksp)
}

kotlin {
    androidTarget {
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
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
            api(libs.kotlinx.serializationCore)
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    add("kspJvm", libs.moshi.kotlinCodegen.get())
}