object Dependencies {
    const val androidGradlePlugin = "com.android.tools.build:gradle:7.0.0-alpha08"

    object Accompanist {
        private const val version = "0.6.0"
        const val coil = "dev.chrisbanes.accompanist:accompanist-coil:$version"
        const val insets = "dev.chrisbanes.accompanist:accompanist-insets:$version"
    }

    object AndroidTools {
        const val desugarJdk = "com.android.tools:desugar_jdk_libs:1.0.9"
    }

    object AndroidX {
        const val activity = "androidx.activity:activity:1.3.0-SNAPSHOT"
        const val activityCompose = "androidx.activity:activity-compose:1.3.0-alpha03"
        const val ktx = "androidx.core:core-ktx:1.5.0-beta01"
        const val core = "androidx.core:core:1.5.0-alpha03"
        const val datastore = "androidx.datastore:datastore-preferences:1.0.0-alpha06"
        const val palette = "androidx.palette:palette:1.0.0"
        const val startup = "androidx.startup:startup-runtime:1.0.0"
        const val work = "androidx.work:work-runtime-ktx:2.5.0"
    }

    object Coil {
        operator fun invoke() = "io.coil-kt:coil:1.1.1"
    }

    object Compose {
        const val version = "1.0.0-beta01"
        const val navigationVersion = "1.0.0-alpha08"
        const val snapshot = "7141639"
        const val snapshotUrl =
            "https://androidx.dev/snapshots/builds/$snapshot/artifacts/repository/"

        const val compiler = "androidx.compose.compiler:compiler:$version"
        const val materialIconsExtended = "androidx.compose.material:material-icons-extended:$version"
        const val material = "androidx.compose.material:material:$version"
        const val navigation = "androidx.navigation:navigation-compose:$navigationVersion"
        const val runtime = "androidx.compose.runtime:runtime:$version"
        const val savable = "androidx.compose.runtime:runtime-saveable:$version"
        const val test = "androidx.compose.ui:ui-test:$version"
        const val tooling = "androidx.compose.ui:ui-tooling:$version"
    }

    object Coroutines {
        private const val version = "1.4.2"
        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
        const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
    }

    object ExoPlayer {
        operator fun invoke() = "com.google.android.exoplayer:exoplayer:2.13.1"
    }

    object Firebase {
        const val analytics = "com.google.firebase:firebase-analytics:17.4.4"
        const val bom = "com.google.firebase:firebase-bom:26.5.0"
        const val auth = "com.google.firebase:firebase-auth-ktx"
        const val crashlyticsPlugin = "com.google.firebase:firebase-crashlytics-gradle:2.2.0"
        const val crashlytics = "com.google.firebase:firebase-crashlytics:17.1.1"
        const val database = "com.google.firebase:firebase-database-ktx"
        const val firestore = "com.google.firebase:firebase-firestore-ktx"
        const val messaging = "com.google.firebase:firebase-messaging:20.2.4"
        const val nl = "com.google.firebase:firebase-ml-natural-language:22.0.0"
        const val smartReply =
            "com.google.firebase:firebase-ml-natural-language-smart-reply-model:20.0.7"
    }

    object Junit {
        operator fun invoke() = "junit:junit:4.13.1"
    }

    object Koin {
        private const val version = "2.2.2"
        const val gradlePlugin = "org.koin:koin-gradle-plugin:$version"
        const val scope = "org.koin:koin-androidx-scope:$version"
        const val core = "org.koin:koin-core-ext:$version"
        const val test = "org.koin:koin-test:$version"
    }

    object Kotlin {
        private const val version = Versions.kotlin
        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib:$version"
        const val reflect = "org.jetbrains.kotlin:kotlin-reflect:$version"
    }

    object LeakCanary {
        operator fun invoke() = "com.squareup.leakcanary:leakcanary-android:2.4"
    }

    object MaterialDialog {
        const val core = "com.afollestad.material-dialogs:core:3.3.0"
        const val datetime = "com.afollestad.material-dialogs:datetime:3.3.0"
    }

    object MlKit {
        const val entityExtraction = "com.google.mlkit:entity-extraction:16.0.0-beta1"
    }

    object Moshi {
        private const val version = "1.11.0"
        const val core = "com.squareup.moshi:moshi:$version"
        const val kotlin = "com.squareup.moshi:moshi-kotlin:$version"
        const val codegen = "com.squareup.moshi:moshi-kotlin-codegen:$version"
    }

    object MpChart {
        operator fun invoke() = "com.github.PhilJay:MPAndroidChart:3.1.0"
    }

    object PlayServices {
        const val gradlePlugin = "com.google.gms:google-services:4.3.5"
        const val ossChecker = "com.google.android.gms:play-services-oss-licenses:17.0.0"
        const val ossCheckerPlugin = "com.google.android.gms:oss-licenses-plugin:0.10.2"
    }

    object Retrofit {
        private const val version = "2.9.0"
        const val core = "com.squareup.retrofit2:retrofit:$version"
        const val moshi = "com.squareup.retrofit2:converter-moshi:$version"
        const val scalars = "com.squareup.retrofit2:converter-scalars:$version"
    }

    object Room {
        private const val version = "2.3.0-beta01"
        const val runtime = "androidx.room:room-runtime:$version"
        const val compiler = "androidx.room:room-compiler:$version"
        const val ktx = "androidx.room:room-ktx:$version"
    }

    object Okhttp {
        private const val version = "5.0.0-alpha.2"
        const val core = "com.squareup.okhttp3:okhttp:$version"
        const val logging = "com.squareup.okhttp3:logging-interceptor:$version"
    }

    object PrettyTime {
        operator fun invoke() = "org.ocpsoft.prettytime:prettytime:5.0.0.Final"
    }

    object Slack {
        const val EitherNet = "com.slack.eithernet:eithernet:0.2.0"
    }

    object Timber {
        operator fun invoke() = "com.jakewharton.timber:timber:4.7.1"
    }

}
