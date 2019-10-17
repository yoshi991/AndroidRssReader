import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler

object Deps {
    object Kotlin {
        const val version = "1.3.41"
        const val stdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$version"
        const val reflect = "org.jetbrains.kotlin:kotlin-reflect:$version"

        object Coroutines {
            const val version = "1.3.1"
            const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
            const val kotlinx = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
        }
    }

    object AndroidX {
        const val appcompat = "androidx.appcompat:appcompat:1.1.0"
        const val coreKtx = "androidx.core:core-ktx:1.1.0"
        const val activityKtx = "androidx.activity:activity-ktx:1.0.0"
        const val fragmentKtx = "androidx.fragment:fragment-ktx:1.2.0-alpha01"
        const val cardview = "androidx.cardview:cardview:1.0.0"
        const val coordinatorLayout = "androidx.coordinatorlayout:coordinatorlayout:1.0.0"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:1.1.3"
        const val recyclerView = "androidx.recyclerview:recyclerview:1.0.0"
        const val swipeRefreshLayout = "androidx.swiperefreshlayout:swiperefreshlayout:1.1.0-alpha02"
        const val viewPager2 = "androidx.viewpager2:viewpager2:1.0.0-beta04"
        const val emoji = "androidx.emoji:emoji-bundled:1.0.0"

        object LifeCycle {
            const val version = "2.2.0-alpha02"
            const val runtime = "androidx.lifecycle:lifecycle-runtime:$version"
            const val compiler = "androidx.lifecycle:lifecycle-compiler:$version"
            const val extension = "androidx.lifecycle:lifecycle-extensions:$version"
            const val liveDataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:$version"
            const val reactivestreams = "androidx.lifecycle:lifecycle-reactivestreams:$version"
        }

        object Navigation {
            const val version = "2.1.0"
            const val fragment = "androidx.navigation:navigation-fragment:$version"
            const val fragmentKtx = "androidx.navigation:navigation-fragment-ktx:$version"
            const val ui = "androidx.navigation:navigation-ui:$version"
            const val uiKtx = "androidx.navigation:navigation-ui-ktx:$version"
            const val gradlePlugin = "androidx.navigation:navigation-safe-args-gradle-plugin:$version"
        }
    }

    object Google {
        const val material = "com.google.android.material:material:1.1.0-alpha09"
        const val flexbox = "com.google.android:flexbox:1.1.0"

        object Dagger {
            const val version = "2.24"
            const val core = "com.google.dagger:dagger:$version"
            const val compiler = "com.google.dagger:dagger-compiler:$version"
            const val androidCore = "com.google.dagger:dagger-android:$version"
            const val androidSupport = "com.google.dagger:dagger-android-support:$version"
            const val androidProcessor = "com.google.dagger:dagger-android-processor:$version"
        }
    }

    object Square {
        object OkHttp {
            const val version = "3.11.0"
            const val client = "com.squareup.okhttp3:okhttp:$version"
            const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:$version"
        }

        object Retrofit {
            const val version = "2.6.1"
            const val core = "com.squareup.retrofit2:retrofit:$version"
            const val converter = "com.squareup.retrofit2:converter-gson:2.4.0"
        }
    }

    object Groupie {
        const val version = "2.3.0"
        const val core = "com.xwray:groupie:$version"
        const val databinding = "com.xwray:groupie-databinding:$version"
    }

    object Glide {
        const val version = "4.9.0"
        const val core = "com.github.bumptech.glide:glide:$version"
        const val okhttp3 = "com.github.bumptech.glide:okhttp3-integration:$version"
        const val compiler = "com.github.bumptech.glide:compiler:$version"
        const val transformations = "jp.wasabeef:glide-transformations:4.1.0"
    }

    object Utility {
        const val threetenabp = "com.jakewharton.threetenabp:threetenabp:1.2.0"
        const val timber = "com.jakewharton.timber:timber:4.7.1"
        const val bugfender = "com.bugfender.sdk:android:1.1.5"

        object Stetho {
            const val version = "1.5.1"
            const val core = "com.facebook.stetho:stetho:$version"
            const val okhttp3 = "com.facebook.stetho:stetho-okhttp3:$version"
            const val urlConnection = "com.facebook.stetho:stetho-urlconnection:$version"
        }

        object Hyperion {
            const val version = "0.9.27"
            const val core = "com.willowtreeapps.hyperion:hyperion-core:$version"
            const val attr = "com.willowtreeapps.hyperion:hyperion-attr:$version"
            const val buildConfig = "com.willowtreeapps.hyperion:hyperion-build-config:$version"
            const val measurement = "com.willowtreeapps.hyperion:hyperion-measurement:$version"
            const val phoenix = "com.willowtreeapps.hyperion:hyperion-phoenix:$version"
            const val disk = "com.willowtreeapps.hyperion:hyperion-disk:$version"
            const val crash = "com.willowtreeapps.hyperion:hyperion-crash:$version"
            const val sharedPreference = "com.willowtreeapps.hyperion:hyperion-shared-preferences:$version"
            const val geigerCounter = "com.willowtreeapps.hyperion:hyperion-geiger-counter:$version"
            const val release = "com.willowtreeapps.hyperion:hyperion-core-no-op:$version"
        }

        object LeakCanary {
            const val version = "1.6.3"
            const val debug = "com.squareup.leakcanary:leakcanary-android:$version"
            const val release = "com.squareup.leakcanary:leakcanary-android-no-op:$version"
        }
    }

    object Test {
        const val junit = "junit:junit:4.12"
        const val junitVintage = "org.junit.vintage:junit-vintage-engine:5.5.0"
        const val mockk = "io.mockk:mockk:1.9"
        const val kotlinTest = "org.jetbrains.kotlin:kotlin-test:1.3.40"
        const val robolectric = "org.robolectric:robolectric:4.3"

        object AndroidX {
            const val core = "androidx.test:core:1.1.1-alpha02"
            const val testCoreKtx = "androidx.test:core-ktx:1.2.0"
            const val runner = "androidx.test:runner:1.2.0"
            const val rules = "androidx.test:rules:1.1.2-alpha02"
            const val junit = "androidx.test.ext:junit:1.1.1-alpha02"
            const val truth = "androidx.test.ext:truth:1.2.0-alpha02"

            object Espresso {
                const val version = "3.2.0"
                const val core = "androidx.test.espresso:espresso-core:$version"
                const val intents = "androidx.test.espresso:espresso-intents:$version"
                const val contrib = "androidx.test.espresso:espresso-contrib:$version"
            }
        }

        object Junit5 {
            const val version = "5.5.0"
            const val api = "org.junit.jupiter:junit-jupiter-api:$version"
            const val params = "org.junit.jupiter:junit-jupiter-params:$version"
            const val engine = "org.junit.jupiter:junit-jupiter-engine:$version"
        }

        object Spek {
            const val version = "2.0.5"
            const val spek = "org.spekframework.spek2:spek-dsl-jvm:$version"
            const val runner = "org.spekframework.spek2:spek-runner-junit5:$version"
        }
    }
}

fun DependencyHandler.impl(dependencyNotation: Any): Dependency? =
    add("implementation", dependencyNotation)

fun DependencyHandler.debugImpl(dependencyNotation: Any): Dependency? =
    add("debugImplementation", dependencyNotation)

fun DependencyHandler.releaseImpl(dependencyNotation: Any): Dependency? =
    add("releaseImplementation", dependencyNotation)

fun DependencyHandler.testImpl(dependencyNotation: Any): Dependency? =
    add("testImplementation", dependencyNotation)

fun DependencyHandler.androidTestImpl(dependencyNotation: Any): Dependency? =
    add("androidTestImplementation", dependencyNotation)

fun DependencyHandler.kapt(dependencyNotation: Any): Dependency? = add("kapt", dependencyNotation)

fun DependencyHandler.compileOnly(dependencyNotation: Any): Dependency? =
    add("compileOnly", dependencyNotation)

fun DependencyHandler.testRuntimeOnly(dependencyNotation: Any): Dependency? =
    add("testRuntimeOnly", dependencyNotation)

