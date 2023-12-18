pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Ch3"
include(":app")
include(":lib3")
include(":ch6")
include(":ch7")
include(":ch8")
include(":ch9")
include(":ch13")
include(":ch14")
include(":ch15")
include(":ch_15_outter")
include(":ch16")
