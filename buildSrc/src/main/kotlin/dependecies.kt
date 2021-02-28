const val kotlinVersion = "1.3.71"

object AppInfo {
    const val identifier = "com.app.purvaassignment"
}

object Android {
    const val compileSdkVersion = 30
    const val minSdk = 24
    const val targetSdk = 30
}

object Binding {
    val compiler = "com.android.databinding:compiler:3.0.1"
}

object Room {
    const val archRoom = "2.2.5"
    val runtime = "android.arch.persistence.room:runtime:${archRoom}"
    val rxjava2 = "android.arch.persistence.room:rxjava2:${archRoom}"
    val compiler = "android.arch.persistence.room:compiler:${archRoom}"
}

object BuildPlugins {

    object Versions {
        const val buildToolsVersion = "3.6.0"
        const val gradle = "4.0.1"
        const val kotlin = "1.4.0"
    }

    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.buildToolsVersion}"
    const val androidApplication = "com.android.application"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
    const val kotlinAndroid = "android"
    const val kotlinAndroidExtensions = "android.extensions"
    const val kaptPlugin = "kapt"
}

object Dependencies {

    private object Versions {
        const val appCompat = "1.1.0"
        const val constraintLayout = "1.1.3"
        const val coroutines = "1.3.7"
        const val callAdapterFectory = "2.4.0"
        const val gson = "2.8.5"
        const val koin = "2.2.0-alpha-1" //"2.0.1
        const val ktx = "1.1.0"
        const val legacySupport = "1.0.0"
        const val lifecycle = "2.1.0"
        const val material = "1.1.0-alpha10"
        const val okHttp = "4.2.1"
        const val retrofit = "2.8.1"
        const val rxAndroid = "2.1.1"
        const val serializationVersion = "0.20.0"
        const val koilVersion = "1.1.0"
        const val sdpLib = "1.0.6"
        const val timber = "4.7.1"
        const val archRoom = "2.2.5"
    }

    //Kotlin
    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion"
    const val ktxCore = "androidx.core:core-ktx:${Versions.ktx}"

    //Support libs
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"

    const val retrofitCallAdapter =
        "com.squareup.retrofit2:adapter-rxjava2:${Versions.callAdapterFectory}"
    const val androidCoroutines =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"

    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    const val gson = "com.google.code.gson:gson:${Versions.gson}"

    const val material = "com.google.android.material:material:${Versions.material}"

    const val rxAndroid = "io.reactivex.rxjava2:rxandroid:${Versions.rxAndroid}"
    const val viewModelScope = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    const val serializationRuntime =
        "org.jetbrains.kotlinx:kotlinx-serialization-runtime:${Versions.serializationVersion}"
    const val lifecycle = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"
    const val koin = "org.koin:koin-android:${Versions.koin}"
    const val koinViewModel = "org.koin:koin-androidx-viewmodel:${Versions.koin}"
    const val legacySupport = "androidx.legacy:legacy-support-v4:${Versions.legacySupport}"

    const val okHttp = "com.squareup.okhttp3:okhttp:${Versions.okHttp}"
    const val okHttpLogging = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"

    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"

    //UI Lib
    const val coilImageLoading = "io.coil-kt:coil:${Versions.koilVersion}"
    const val sdpLib = "com.intuit.sdp:sdp-android:${Versions.sdpLib}"

}

object TestDependencies {

    private object Versions {
        const val androidxTestRunner = "1.1.0"
        const val espressoCore = "3.2.0"
        const val junit = "5.4.2"
    }

    const val androidxTestRunner = "androidx.test:runner:${Versions.androidxTestRunner}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
    const val junit = "org.junit.jupiter:junit-jupiter-engine:${Versions.junit}"
    const val testInstrumentationRunner = "androidx.test.runner.AndroidJunitRunner"
}