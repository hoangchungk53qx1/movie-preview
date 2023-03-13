plugins {
    alias(libs.plugins.kotlin.jvm)
}

dependencies {
    api(project(":core:core-common"))
    api(project(":core:core-network"))

    implementation(libs.kotlinx.datetime)
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.javax.inject)
    implementation(libs.androidx.paging.common)
}