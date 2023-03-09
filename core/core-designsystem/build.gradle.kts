android {
    buildTypes {
        create("benchmark") {
        }
    }
}
plugins {
    id("movie-preview.android.library")
    id("movie-preview.android.library.compose")
}
android.namespace = "com.chungha.movie_preview.core_designsystem"

dependencies {
    api(libs.bundles.androidx.compose)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.dagger.hilt.android)
    api(libs.accompanist.swiperefresh)
    api(libs.accompanist.placeholder.material)

    api(libs.coil.compose)
    debugApi(libs.androidx.compose.ui.tooling)
    debugApi(libs.androidx.compose.ui.test.manifest)

//    implementation("androidx.core:core-ktx:1.7.0")
//    implementation("androidx.appcompat:appcompat:1.6.0")
//    implementation("com.google.android.material:material:1.8.0")
//    testImplementation("junit:junit:4.13.2")
//    androidTestImplementation("androidx.test.ext:junit:1.1.5")
//    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}