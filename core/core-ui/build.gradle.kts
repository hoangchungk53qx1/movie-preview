
plugins {
    id("movie-preview.android.library")
    id("movie-preview.android.library.compose")
}

android.namespace = "com.chungha.movie_preview.core.ui"

dependencies {
    api(project(":core:core-designsystem"))
//    api(project(":core:core-navigation"))
    api(project(":core:core-model"))
    api(project(":core:core-domain"))

    implementation(libs.kotlinx.datetime)
    implementation(libs.lottie.compose)
    implementation(libs.accompanist.pager)
    implementation(libs.accompanist.pager.indicators)
    implementation(libs.androidx.paging.compose)
}
