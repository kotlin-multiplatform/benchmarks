import kotlinx.benchmark.gradle.JvmBenchmarkTarget
import kotlinx.benchmark.gradle.NativeBenchmarkTarget
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.plugin.mpp.NativeBuildType

plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.goncalossilvaResources)
    alias(libs.plugins.kotlinAllOpen)
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.kotlinxBenchmark)
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
            implementation(libs.kmp.common.ktor)
            implementation(libs.kotlinx.benchmark)
            implementation(libs.kotlinx.datetime)
            implementation(libs.kotlinx.serialization.json)
            implementation(libs.ktor.client.content.negotiation)
            implementation(libs.ktor.client.logging)
            implementation(libs.ktor.serialization.kotlinx.json)
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

allOpen {
    annotation("org.openjdk.jmh.annotations.State")
}

benchmark {
    configurations {
        getByName("main") {
            warmups = 10
            iterations = 10
            iterationTime = 250
            iterationTimeUnit = "ms"
            outputTimeUnit = "ms"
            mode = "AverageTime"
//            advanced("jvmForks", "definedByJmh")
        }
//        getByName("smoke") {
//            warmups = 5
//            iterations = 3
//            iterationTime = 500
//            iterationTimeUnit = "ms"
//        }
    }

    targets {
        register("jvmTest") {
            this as JvmBenchmarkTarget
            jmhVersion = "1.37"
        }
//        register("iosArm64Test")
        register("macosArm64Test")
//        register("native") {
//            this as NativeBenchmarkTarget
//            buildType = NativeBuildType.DEBUG
//        }
    }
}