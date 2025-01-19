plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.ned.core"
    compileSdk = 34

    defaultConfig {
        minSdk = 21

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit.jupiter)
    testImplementation (libs.junit)
    testImplementation(libs.junit.junit)
    testImplementation(libs.junit.junit)
    testImplementation(libs.junit.junit)
    testImplementation(libs.junit.junit)
    androidTestImplementation(libs.androidx.junit)
    testImplementation (libs.junit.jupiter.engine)
    testImplementation (libs.junit.jupiter.api)

    androidTestImplementation(libs.androidx.espresso.core)

    implementation (libs.kotlinx.coroutines.android)
    implementation (libs.koin.android)
    implementation (libs.koin.androidx.compose)

    testImplementation (libs.mockk)
    testImplementation (libs.kotlinx.coroutines.test)
    testImplementation (libs.kotlinx.coroutines.core)

}