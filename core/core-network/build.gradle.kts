
plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlin.serialization)
}

//android.namespace = "com.chungha.movie_preview.core_network"

dependencies {
    implementation(project(":core:core-common"))
    implementation(project(":core:core-model"))

    implementation(libs.kotlinx.datetime)
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.bundles.retrofit)
    implementation(libs.javax.inject)

}