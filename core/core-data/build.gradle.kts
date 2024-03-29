plugins {
    id("movie-preview.android.library")
    id("movie-preview.android.hilt")
    id("kotlinx-serialization")
}

android.namespace = "com.chungha.movie_preview.core.data"

dependencies {
    implementation(project(":core:core-network"))
    implementation(project(":core:core-domain"))

    implementation(libs.kotlinx.datetime)
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.javax.inject)
    implementation(libs.androidx.paging.common)
}