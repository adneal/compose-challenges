plugins {
    id("com.android.application")
    id("koin")
    id("com.google.secrets_gradle_plugin") version "0.5"
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
}

kapt {
    correctErrorTypes = true
    useBuildCache = true
}

android {
    compileSdkVersion(Versions.compileSdk)
    buildToolsVersion(Versions.buildTools)

    defaultConfig {
        applicationId = "org.seeingpixels.adoptionimpact"
        testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
        minSdkVersion(Versions.minSdk)
        targetSdkVersion(Versions.targetSdk)
        versionName = "1.0.0-dev01"
        versionCode = 1
    }

    signingConfigs {
        getByName("debug") {
            storeFile = rootProject.file("debug.keystore")
            storePassword = "android"
            keyAlias = "androiddebugkey"
            keyPassword = "android"
        }
    }

    buildTypes {
        getByName("debug") {
            isMinifyEnabled = false
            signingConfig = signingConfigs.getByName("debug")
        }
        getByName("release") {
            isMinifyEnabled = true
        }
    }

    buildFeatures {
        compose = true
    }
    compileOptions {
        isCoreLibraryDesugaringEnabled = true
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Dependencies.Compose.version
    }
}

dependencies {
    kapt(Dependencies.Moshi.codegen)
    kapt(Dependencies.Room.compiler)
    coreLibraryDesugaring(Dependencies.AndroidTools.desugarJdk)

    implementation(Dependencies.Coil())
    implementation(Dependencies.PrettyTime())
    implementation(Dependencies.Timber())

    Dependencies.Accompanist.apply {
        implementation(coil)
        implementation(insets)
    }
    Dependencies.AndroidX.apply {
        implementation(activity)
        implementation(activityCompose)
        implementation(palette)
        implementation(startup)
    }
    Dependencies.Compose.apply {
        implementation(material)
        implementation(materialIconsExtended)
        implementation(navigation)
        implementation(savable)
        implementation(tooling)
        androidTestImplementation(test)
    }
    Dependencies.Coroutines.apply {
        implementation(core)
        implementation(android)
    }
    Dependencies.Koin.apply {
        implementation(scope)
        implementation(core)
        implementation(test)
    }
    Dependencies.Kotlin.apply {
        implementation(stdlib)
        implementation(reflect)
    }
    Dependencies.Moshi.apply {
        implementation(core)
        implementation(kotlin)
    }
    Dependencies.Okhttp.apply {
        implementation(core)
        implementation(logging)
    }
    Dependencies.Retrofit.apply {
        implementation(core)
        implementation(moshi)
        implementation(scalars)
    }
    Dependencies.Room.apply {
        implementation(runtime)
        implementation(ktx)
    }
    testImplementation(Dependencies.Junit())
}