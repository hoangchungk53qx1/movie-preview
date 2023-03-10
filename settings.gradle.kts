pluginManagement {
    includeBuild("build-logic")
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "movie-preview"
include(":app")


include(":core")
include(":core:core-common")
include(":core:core-designsystem")
include(":feature")
include(":feature:feature-home")
include(":feature:feature-search")
include(":feature:feature-favorite")
include(":feature:feature-setting")
include(":core:core-ui")
