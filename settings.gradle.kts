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
include(":core:core-ui")
include(":feature")
include(":core:core-common")
include(":core:core-domain")
include(":core:core-model")
include(":core:core-network")
include(":core:core-data")
include(":core:core-navigation")
include(":core:core-database")
include(":core:core-datastore")
include(":core:core-designsystem")
