android {
    buildTypes {
        create("benchmark") {
        }
    }
}
plugins {
    id("movie-preview.android.library")
    id("movie-preview.android.library.compose")
    id("movie-preview.android.feature")
}

android.namespace = "com.preview.feature.search_feature"


dependencies {
    implementation(project(":core:core-data"))
    implementation(libs.kotlinx.datetime)
    implementation(libs.livedata.runtime)
    implementation(libs.livedata.ktx)
    implementation(libs.accompanist.pager)
    implementation(libs.accompanist.pager.indicators)
}