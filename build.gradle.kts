import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("com.diffplug.spotless") version "5.7.0"
}

buildscript {
    repositories {
        google()
        jcenter()
        gradlePluginPortal()
        maven(url = "http://dl.bintray.com/kotlin/kotlin-eap")
    }

    dependencies {
        classpath(Dependencies.androidGradlePlugin)
        classpath(Dependencies.Kotlin.gradlePlugin)
        classpath(Dependencies.Koin.gradlePlugin)
    }
}

subprojects {
    apply {
        plugin("com.diffplug.spotless")
    }
    repositories {
        google()
        jcenter()
        maven(url = "https://jitpack.io")
        maven(url = "https://dl.bintray.com/kotlin/kotlin-eap")
        maven(url = "https://oss.sonatype.org/content/repositories/snapshots/")
        if (Dependencies.Compose.version.endsWith("SNAPSHOT")) {
            maven(url = Dependencies.Compose.snapshotUrl)
        }
    }
    tasks.withType<KotlinCompile>().configureEach {
        kotlinOptions {
            useIR = true
            jvmTarget = Versions.java
            freeCompilerArgs = freeCompilerArgs + listOf(
                "-Xopt-in=kotlin.RequiresOptIn",
                "-Xjvm-default=enable"
            )
        }
    }
    spotless {
        kotlin {
            target("**/*.kt")
            targetExclude("$buildDir/**/*.kt")
            targetExclude("bin/**/*.kt")

            ktlint("0.40.0")
            licenseHeaderFile(rootProject.file("spotless/copyright.kt"))
        }
    }
}