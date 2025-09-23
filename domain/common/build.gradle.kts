plugins {
    alias(libs.plugins.tennisapp.android.library)
    alias(libs.plugins.tennisapp.hilt)
    alias(libs.plugins.tennisapp.android.library.detekt)
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "com.glacierpower.tennisapp.domain.common"
}

dependencies {
    implementation(projects.core.network)
    implementation(libs.kotlin.serialization.json)
}