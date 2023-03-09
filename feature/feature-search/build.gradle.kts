plugins {
    id("movie-preview.android.library")
    id("movie-preview.android.library.compose")
    id("movie-preview.android.feature")
}

android.namespace = "com.preview.feature.search_feature"


dependencies {
    implementation(libs.kotlinx.datetime)
    implementation(libs.accompanist.pager)
    implementation(libs.accompanist.pager.indicators)
}