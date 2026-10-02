plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.plugin.compose")
    id("com.google.devtools.ksp")
}
android {
    namespace = "vn.songkhoe.ai"
    compileSdk = 36
    defaultConfig {
        applicationId = "vn.songkhoe.ai"
        minSdk = 24
        targetSdk = 36
        versionCode = 4
        versionName = "3.4"
    }
    buildFeatures { compose = true; buildConfig = true }
}
dependencies {
    implementation("androidx.core:core-ktx:1.17.0")
    implementation("androidx.activity:activity-compose:1.11.0")
    implementation("androidx.compose.material3:material3:1.3.2")
    implementation("androidx.compose.ui:ui:1.8.3")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.9.4")
    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.9.4")
    implementation("androidx.navigation:navigation-compose:2.9.4")
    implementation("androidx.room:room-runtime:2.7.2")
    implementation("androidx.room:room-ktx:2.7.2")
    ksp("androidx.room:room-compiler:2.7.2")
    implementation("androidx.work:work-runtime-ktx:2.10.3")
    implementation("androidx.camera:camera-camera2:1.4.2")
    implementation("androidx.camera:camera-lifecycle:1.4.2")
    implementation("androidx.camera:camera-view:1.4.2")
    implementation("com.squareup.okhttp3:okhttp:4.12.0")
}
