android {
    buildTypes {
        create("benchmark") {
        }
    }
}
plugins {
    id("movie-preview.android.library")
    id("movie-preview.android.feature")
}

android.namespace = "com.preview.flowext"


dependencies {
    implementation(project(":core:core-data"))
    implementation(libs.kotlinx.coroutines.core)
}