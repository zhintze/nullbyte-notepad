pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
        maven { url = uri("https://chaquo.com/maven") }
    }
    plugins {
        id("com.android.application") version "8.4.0"
        id("com.chaquo.python") version "12.0.0"
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.PREFER_PROJECT)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "nullbyte-notepad"
include(":app")
