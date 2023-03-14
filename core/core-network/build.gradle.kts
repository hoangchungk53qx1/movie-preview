plugins {
    id("movie-preview.android.library")
    id("movie-preview.android.hilt")
    id("kotlinx-serialization")
}

android {
    namespace = "com.chungha.core_network"
    buildFeatures {
        buildConfig = true
    }
    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }
}

dependencies {
    implementation(project(":core:core-common"))
    implementation(project(":core:core-model"))
    implementation(project(":core:core-data"))

    implementation(libs.kotlinx.datetime)

    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.bundles.retrofit)
    implementation(libs.javax.inject)
}