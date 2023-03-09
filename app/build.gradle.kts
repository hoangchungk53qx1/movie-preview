import org.gradle.kotlin.dsl.*
import org.gradle.kotlin.dsl.accessors.runtime.*

plugins {
    id("movie-preview.android.application")
    id("movie-preview.android.application.compose")
    id("movie-preview.android.lint")
    id("movie-preview.android.signingconfig")
    id("movie-preview.apikey.provider")
//
//    alias(libs.plugins.kotlin.kapt)
//    alias(libs.plugins.dagger.hilt.android)
}

@Suppress("UnstableApiUsage")
android {
    namespace = "com.chungha.movie_preview"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.chungha.movie_preview"
        minSdk = 26
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }
}

dependencies {
    //add sub module
    implementation(project(":core:core-designsystem"))
    implementation(project(":feature:feature-home"))
    implementation(project(":feature:feature-search"))
    implementation(project(":feature:feature-favorite"))
    implementation(project(":feature:feature-setting"))


    // lib
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.3.3")

    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation("androidx.compose.ui:ui-test-manifest:1.3.3")


    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.compose.bom)

    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.material3.windowSizeClass)
    implementation(libs.androidx.compose.bom)
    implementation(libs.androidx.compose.ui.tooling)
    implementation(libs.androidx.tracing.ktx)

    implementation(libs.androidx.core.splashscreen)
    implementation(libs.androidx.profileinstaller)
    implementation(libs.accompanist.systemuicontroller)

    implementation(libs.kotlinx.serialization.json)
    implementation(libs.androidx.navigation.compose)

    implementation(libs.dagger.hilt.android)

    implementation(libs.androidx.room.runtime)
}