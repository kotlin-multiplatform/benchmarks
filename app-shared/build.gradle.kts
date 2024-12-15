import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
}

kotlin {
    androidTarget {
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }

//    jvm()
    
    listOf(
//        iosX64(),
        iosArm64(),
        iosSimulatorArm64(),
//        macosX64()
//        macosArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "BenchmarksShared"
            isStatic = true
//            export(projects.shared.networking)
            export(projects.shared.serialization)
            export(projects.shared.serialization.model)
        }
    }

    sourceSets {
        commonMain.dependencies {
//            api(projects.shared.networking)
            api(projects.shared.serialization)
            api(projects.shared.serialization.model)
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}

android {
    namespace = "kmp.benchmarks"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}
