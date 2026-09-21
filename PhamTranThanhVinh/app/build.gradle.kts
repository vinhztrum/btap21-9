plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.ute.phamtranthanhvinh"
    compileSdk {
        version = release(37)
    }

    defaultConfig {
        applicationId = "com.ute.phamtranthanhvinh"
        minSdk = 24
        targetSdk = 37
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            optimization {
                enable = false
            }
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    implementation(libs.androidx.activity.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.core.ktx)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)
}
android {
    namespace = "com.example.studentprofile"
    compileSdk = 35
    defaultConfig {
        applicationId = "com.example.studentprofile"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"
    }
// ── KÍCH HOẠT VIEWBINDING TẠI ĐÂY ────────────────────────
    buildFeatures {
        viewBinding = true
    }
}