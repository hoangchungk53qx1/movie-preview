import org.gradle.kotlin.dsl.*
import org.gradle.kotlin.dsl.accessors.runtime.*

plugins {
    id("movie-preview.android.application")
    id("movie-preview.android.application.compose")
    id("movie-preview.android.lint")
    id("movie-preview.android.signingconfig")
    id("movie-preview.apikey.provider")
//
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.dagger.hilt.android)
}

@Suppress("UnstableApiUsage")
android {
    namespace = "com.chungha.movie_preview"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.chungha.movie_preview"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }
    kotlinOptions {
        val experimentalOptIns = listOf(
            "-Xopt-in=androidx.compose.ui.ExperimentalComposeUiApi",
            "-Xopt-in=com.google.accompanist.pager.ExperimentalPagerApi",
            "-Xopt-in=androidx.compose.ui.graphics.ExperimentalGraphicsApi",
            "-Xopt-in=androidx.compose.animation.ExperimentalAnimationApi",
            "-Xopt-in=kotlinx.coroutines.FlowPreview",
            "-Xopt-in=kotlinx.coroutines.ExperimentalCoroutinesApi"
        )

        freeCompilerArgs =
            freeCompilerArgs + experimentalOptIns

        jvmTarget = "11"
    }
}

dependencies {
    //add sub module
    implementation(project(":core:core-designsystem"))
    implementation(project(":core:core-network"))
    implementation(project(":core:core-data"))
    implementation(project(":core:core-domain"))
    implementation(project(":core:core-model"))
    implementation(project(":core:core-ui"))


    implementation(project(":feature:feature-home"))
    implementation(project(":feature:feature-search"))
    implementation(project(":feature:feature-favorite"))
    implementation(project(":feature:feature-setting"))
    implementation(project(":feature:feature-preview"))


    // lib
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.androidx.test.espresso.core)
    androidTestImplementation(libs.androidx.ui.test.junit4)

    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)


    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))

    implementation(libs.immutable.list)

    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.material3.windowSizeClass)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui.tooling)
    implementation(libs.androidx.tracing.ktx)

    implementation(libs.androidx.core.splashscreen)
    implementation(libs.androidx.profileinstaller)
    implementation(libs.accompanist.systemuicontroller)

    implementation(libs.kotlinx.serialization.json)
    implementation(libs.androidx.navigation.compose)

    implementation(libs.dagger.hilt.android)
    kapt(libs.dagger.hilt.compiler)
    implementation(libs.androidx.room.runtime)
}