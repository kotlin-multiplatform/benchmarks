import kotlinx.benchmark.gradle.JvmBenchmarkTarget
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.goncalossilva.resources)
    alias(libs.plugins.kotlin.allOpen)
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.kotlinx.benchmark)
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
            implementation(libs.kotlinx.benchmark)
            api(libs.kotlinx.serializationJson)
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
//        register("native") {
//            this as NativeBenchmarkTarget
//            buildType = NativeBuildType.DEBUG
//        }
    }
}