plugins {
    id("movie-preview.android.library")
    id("movie-preview.android.hilt")
    id("kotlinx-serialization")
}

android {
    namespace = "com.chungha.core_domain"
}

dependencies {
    api(project(":core:core-common"))
    api(project(":core:core-network"))

    implementation(libs.kotlinx.datetime)
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.javax.inject)
    implementation(libs.androidx.paging.common)

}