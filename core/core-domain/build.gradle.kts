plugins {
    alias(libs.plugins.kotlin.jvm)
}

dependencies {
    api(project(":core:core-common"))

    implementation(libs.kotlinx.datetime)
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.javax.inject)
    implementation(libs.androidx.paging.common)
}