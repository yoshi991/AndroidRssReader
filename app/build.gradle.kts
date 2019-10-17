import de.mannodermaus.gradle.plugins.junit5.junitPlatform
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    kotlin("android.extensions")
    id("kotlinx-serialization")
    id("androidx.navigation.safeargs")
    id("org.jmailen.kotlinter")
    id("de.mannodermaus.android-junit5")
    id("jacoco")
}

android {
    compileSdkVersion(29)

    defaultConfig {
        applicationId = "inc.android.androidrssreader"
        minSdkVersion(21)
        targetSdkVersion(29)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isDebuggable = false
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            isShrinkResources = true
            isZipAlignEnabled = true

            buildConfigField("String", "API_URL", "\"https://s3-ap-northeast-1.amazonaws.com/m-et/Android/json/\"")
        }

        getByName("debug") {
            isDebuggable = true
            applicationIdSuffix = ".debug"
            versionNameSuffix = "-DEBUG"
            signingConfig = signingConfigs["debug"]

            buildConfigField("String", "API_URL", "\"https://s3-ap-northeast-1.amazonaws.com/m-et/Android/json/\"")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    dataBinding {
        isEnabled = true
    }

    androidExtensions {
        isExperimental = true
    }

    sourceSets {
        getByName("main").java.srcDirs("src/main/kotlin")
        getByName("test").java.srcDirs("src/test/kotlin")
        getByName("androidTest").java.srcDirs("src/androidTest/kotlin")
    }

    packagingOptions {
        exclude("META-INF/rxjava.properties")
        exclude("META-INF/LICENSE*")
    }

    tasks.withType(KotlinCompile::class.java).all {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xallow-result-return-type")
            jvmTarget = "1.8"
        }
    }

    kotlinter {
        ignoreFailures = true
        reporters = arrayOf("checkstyle", "plain")
        indentSize = 4
    }

    lintOptions {
        lintConfig = file("${rootDir.absolutePath}/lint/lint.xml")
        isQuiet = true
        isAbortOnError = false
        isIgnoreWarnings = true
        disable("IndefidPackage")            //Some libraries have issues with this.
        disable("OldTargetApi")              //Lint gives this warning but SDK 20 would be Android L Beta.
        disable("IconDensities")             //For testing purpose. This is safe to remove.
        disable("IconMissingDensityFolder")  //For testing purpose. This is safe to remove.
    }

    testOptions {
        unitTests.apply {
            isIncludeAndroidResources = true
            all(KotlinClosure1<Any, Test>({
                (this as Test).apply { testLogging.events("passed", "skipped", "failed") }
            }, this))
        }

        junitPlatform {
            filters.includeEngines("spek2", "junit-vintage")
            jacocoOptions {
                html.enabled = true
                xml.enabled = false
                csv.enabled = false
            }
        }
    }
}

dependencies {
    impl(fileTree("dir" to "libs", "include" to listOf("*.jar")))

    Deps.Kotlin.run {
        impl(stdLib)
        impl(reflect)
    }
    Deps.Kotlin.Coroutines.run {
        impl(core)
        impl(kotlinx)
    }

    Deps.AndroidX.run {
        impl(appcompat)
        impl(coreKtx)
        impl(activityKtx)
        impl(fragmentKtx)
        impl(constraintLayout)
        impl(cardview)
        impl(coordinatorLayout)
        impl(recyclerView)
        impl(swipeRefreshLayout)
        impl(viewPager2)
        impl(emoji)
    }

    Deps.AndroidX.LifeCycle.run {
        impl(runtime)
        kapt(compiler)
        impl(extension)
        impl(liveDataKtx)
    }

    Deps.AndroidX.Navigation.run {
        impl(fragment)
        impl(fragmentKtx)
        impl(ui)
        impl(uiKtx)
    }

    Deps.Google.run {
        impl(material)
        impl(flexbox)
    }

    Deps.Google.Dagger.run {
        impl(core)
        kapt(compiler)
        impl(androidCore)
        impl(androidSupport)
        kapt(androidProcessor)
    }

    Deps.Square.OkHttp.run {
        impl(client)
        impl(loggingInterceptor)
    }
    Deps.Square.Retrofit.run {
        impl(core)
        impl(converter)
    }

    Deps.Glide.run {
        impl(core)
        impl(okhttp3)
        kapt(compiler)
        impl(transformations)
    }

    Deps.Groupie.run {
        impl(core)
        impl(databinding)
    }

    Deps.Utility.run {
        impl(threetenabp)
        impl(timber)
        impl(bugfender)
    }
    Deps.Utility.Stetho.run {
        impl(core)
        impl(okhttp3)
        impl(urlConnection)
    }
    Deps.Utility.Hyperion.run {
        debugImpl(core)
        debugImpl(attr)
        debugImpl(buildConfig)
        debugImpl(phoenix)
        debugImpl(measurement)
        debugImpl(disk)
        debugImpl(crash)
        debugImpl(sharedPreference)
        debugImpl(geigerCounter)
        releaseImpl(release)
    }
    Deps.Utility.LeakCanary.run {
        debugImpl(debug)
        releaseImpl(release)
    }

    Deps.Test.run {
        testImpl(junit)
        testRuntimeOnly(junitVintage)
        testImpl(kotlinTest)
        testImpl(mockk)
        testImpl(robolectric)
    }
    Deps.Test.AndroidX.run {
        testImpl(core)
        testImpl(testCoreKtx)
        testImpl(runner)
        testImpl(rules)
        testImpl(junit)
        testImpl(truth)
    }
    Deps.Test.AndroidX.Espresso.run {
        androidTestImpl(core)
        androidTestImpl(intents)
        androidTestImpl(contrib)
    }
    Deps.Test.Junit5.run {
        testImpl(api)
        testImpl(params)
        testRuntimeOnly(engine)
    }
    Deps.Test.Spek.run {
        testImpl(spek)
        testRuntimeOnly(runner)
    }
}

repositories {
    mavenCentral()
    flatDir {
        dirs("libs")
    }
}

val ktlint by configurations.creating
dependencies {
    ktlint("com.pinterest:ktlint:0.33.0")
    // additional 3rd party ruleset(s) can be specified here
    // just add them to the classpath (e.g. ktlint 'groupId:artifactId:version') and
    // ktlint will pick them up
}
tasks.create("ktlint", type = JavaExec::class) {
    group = "verification"
    classpath = ktlint
    main = "com.pinterest.ktlint.Main"
    args(
        "--android",
        "--color",
        "--reporter=plain",
        "--reporter=checkstyle,output=$buildDir/reports/ktlint-results.xml",
        "src/**/*.kt"
    )
    isIgnoreExitValue = false
}

tasks.named("check") {
    dependsOn(ktlint)
}

task("ktlintFormat", JavaExec::class) {
    description = "Fix Kotlin code style deviations."
    classpath = ktlint
    main = "com.pinterest.ktlint.Main"
    args("-F", "src/**/*.kt")
}

jacoco {
    toolVersion = "0.8.3"
}

tasks.withType<JacocoReport> {
    val excludeFiles = listOf(
        "**/R*.class",
        "**/BuildConfig",
        "**/*Test*.*",
        "**/*Dagger*Component.*",
        "**/*Module.*"
    )

    group = "Reporting"
    description = "Generate Jacoco coverage reports after running"
    classDirectories.setFrom(
        files(
            fileTree(
                "dir" to "$buildDir/tmp/kotlin-classes/debug",
                "excludes" to excludeFiles
            )
        )
    )
    sourceDirectories.setFrom(files("$buildDir/src/main/kotlin"))
    reports {
        xml.isEnabled = true
        html.isEnabled = true
        csv.isEnabled = false
        xml.destination = File("$buildDir/reports/jacoco/report.xml")
        html.destination = File("$buildDir/reports/jacoco/report.html")
    }
}
