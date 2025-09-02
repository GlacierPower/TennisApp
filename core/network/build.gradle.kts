plugins {
    alias(libs.plugins.tennisapp.android.library)
    alias(libs.plugins.tennisapp.hilt)
    alias(libs.plugins.tennisapp.android.library.detekt)
}

android {
    namespace = "com.tennisapp.core.network"
}

dependencies {
    implementation(libs.retrofit)
    implementation(libs.kotlin.serialization.json)
    implementation(libs.logging.interceptor)
    implementation(libs.converter.moshi)
    implementation(libs.converter.gson)
    implementation(libs.moshi.kotlin)
}
