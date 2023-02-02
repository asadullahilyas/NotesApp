plugins {
    id("com.android.application")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
    kotlin("android")
}

android {
    namespace = "com.example.firstkmmapp.android"
    compileSdk = 33
    defaultConfig {
        applicationId = "com.example.firstkmmapp.android"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.3.0"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}

dependencies {
    implementation(project(":shared"))
    implementation("androidx.compose.ui:ui:1.3.3")
    implementation("androidx.compose.ui:ui-tooling:1.3.3")
    implementation("androidx.compose.ui:ui-tooling-preview:1.3.3")
    implementation("androidx.compose.foundation:foundation:1.3.1")
    implementation("androidx.compose.material:material:1.3.1")
    implementation("androidx.activity:activity-compose:1.6.1")
    coreLibraryDesugaring("com.android.tools:desugar_jdk_libs:2.0.0")

    implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.4.0")

    implementation("com.google.dagger:hilt-android:2.44.2")
    implementation("androidx.core:core-ktx:1.9.0")
    kapt("com.google.dagger:hilt-compiler:2.44.2")
    kapt("androidx.hilt:hilt-compiler:1.0.0")

    implementation("androidx.hilt:hilt-navigation-compose:1.0.0")
}