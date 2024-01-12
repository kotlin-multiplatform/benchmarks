import kotlinx.benchmark.gradle.JvmBenchmarkTarget

plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.goncalossilvaResources)
    alias(libs.plugins.kotlinAllOpen)
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.kotlinSerialization)
    alias(libs.plugins.kotlinxBenchmark)
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
            implementation(libs.kotlinx.benchmark)
            api(libs.kotlinx.serialization.json)
            api(projects.shared.serialization.model)
        }
        commonTest.dependencies {
            implementation(libs.goncalossilva.resources)
            implementation(libs.kotlin.test)
        }
    }
}

android {
    namespace = "kmp.benchmarks.serialization"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
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
            iterationTime = 500
            iterationTimeUnit = "ms"
            outputTimeUnit = "ms"
            mode = "AverageTime"
            advanced("jvmForks", "definedByJmh")
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
    }
}