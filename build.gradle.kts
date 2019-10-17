// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    repositories {
        google()
        jcenter()
        maven(url = "https://plugins.gradle.org/m2/")
        maven(url = "https://jitpack.io")
        maven(url = "https://dl.bintray.com/spekframework/spek-dev")
    }
    dependencies {
        classpath("com.android.tools.build:gradle:3.5.1")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Deps.Kotlin.version}")
        classpath("org.jetbrains.kotlin:kotlin-serialization:${Deps.Kotlin.version}")

        classpath("org.jmailen.gradle:kotlinter-gradle:1.26.0")

        // Navigation
        classpath(Deps.AndroidX.Navigation.gradlePlugin)

        // Test
        classpath("de.mannodermaus.gradle.plugins:android-junit5:1.4.2.1")
        classpath("org.jacoco:org.jacoco.core:0.8.1")

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle.kts files
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        maven(url = "https://jitpack.io")
        maven(url = "https://dl.bintray.com/spekframework/spek-dev")
    }
}

tasks.create("clean", type = Delete::class) {
    delete(rootProject.buildDir)
}

tasks.create("runUnitTests") {
    dependsOn(":app:testDebugUnitTest")
    description = "Run all unit tests"
}

tasks.create("runAcceptanceTests") {
    dependsOn(":app:connectedAndroidTest")
    description = "Run all acceptance tests."
}
