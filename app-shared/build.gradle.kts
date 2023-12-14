plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    
    listOf(
//        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "BenchmarksShared"
            isStatic = true
            export(projects.shared.networking)
            export(projects.shared.serialization)
        }
    }

    sourceSets {
        commonMain.dependencies {
            api(projects.shared.networking)
            api(projects.shared.serialization)
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
}
