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
}
