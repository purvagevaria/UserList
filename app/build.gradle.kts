import java.util.*

val kotlin_version: String by extra

plugins {
    id(BuildPlugins.androidApplication)
    kotlin(BuildPlugins.kotlinAndroid)
    kotlin(BuildPlugins.kotlinAndroidExtensions)
    kotlin(BuildPlugins.kaptPlugin)
}
apply {
    plugin("kotlin-android")
}

var versionProps = Properties()
var keystoreProps = Properties()
val version = versionProps["version"].toString()
val buildNumber = 1.toInt()

android {
    dataBinding {
        isEnabled = true
    }
    viewBinding {
        isEnabled = true
    }
    compileSdkVersion(Android.compileSdkVersion)
    defaultConfig {
        applicationId = AppInfo.identifier
        minSdkVersion(Android.minSdk)
        targetSdkVersion(Android.targetSdk)
        versionCode = buildNumber
        versionName = version
        testInstrumentationRunner = TestDependencies.testInstrumentationRunner


        buildTypes {
            getByName("release") {
                isMinifyEnabled = false
                proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
                )
                buildConfigField("String", "BASE_URL", "\" https://randomuser.me/api/\"")
            }
            getByName("debug") {
                isMinifyEnabled = false
                isDebuggable = true
                buildConfigField("String", "BASE_URL", "\" https://randomuser.me/api/\"")

            }
        }

        lintOptions {
            xmlReport = true
            setXmlOutput(file("${project.rootDir}/build/reports/lint/lint-report.xml"))
        }

    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    flavorDimensions("default")

    productFlavors {
        create("phone") {
            setDimension("default")
        }
    }
}


dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    //Kotlin
    implementation(Dependencies.kotlinStdLib)
    implementation(Dependencies.ktxCore)

    //Support lib
    implementation(Dependencies.appCompat)
    implementation(Dependencies.constraintLayout)

    //Test implementation
    testImplementation(TestDependencies.junit)
    androidTestImplementation(TestDependencies.androidxTestRunner)
    androidTestImplementation(TestDependencies.espressoCore)

    //UI Kuv
    implementation(Dependencies.coilImageLoading)
    implementation(Dependencies.sdpLib)
    implementation(Dependencies.material)

    implementation(Dependencies.timber)

    implementation(Dependencies.androidCoroutines)
    implementation(Dependencies.coroutines)
    implementation(Dependencies.koin)
    implementation(Dependencies.koinViewModel)
    implementation(Dependencies.legacySupport)
    implementation(Dependencies.lifecycle)
    implementation(Dependencies.rxAndroid)
    implementation(Dependencies.viewModelScope)

    //Network call
    implementation(Dependencies.serializationRuntime)
    implementation(Dependencies.retrofitCallAdapter)
    implementation(Dependencies.retrofit)
    implementation(Dependencies.gson)
    implementation(Dependencies.okHttp)
    implementation(Dependencies.okHttpLogging)
    implementation(Dependencies.retrofitConverter)

    //Room db
    implementation(Room.runtime)
    implementation(Room.rxjava2)
    //kapt(listOf(Room.compiler))
    // kapt(listOf(Binding.compiler))
    kapt(Room.compiler)
    kapt(Binding.compiler)
}


repositories {
    maven("https://dl.bintray.com/kotlin/kotlin-eap")
    mavenCentral()
}