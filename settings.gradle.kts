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


//include(":core")
include(":core:core-common")
include(":core:core-designsystem")
include(":core:core-ui")
include(":core:core-model")
include(":core:core-data")
include(":core:core-network")
include(":core:core-domain")
include(":feature:feature-home")
include(":feature:feature-search")
include(":feature:feature-favorite")
include(":feature:feature-setting")

include(":flowredux")
include(":flowext")
