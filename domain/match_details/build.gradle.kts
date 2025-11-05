plugins {
    alias(libs.plugins.tennisapp.android.library)
    alias(libs.plugins.tennisapp.hilt)
    alias(libs.plugins.tennisapp.android.library.detekt)
}

android {
    namespace = "com.glacierpower.tennisapp.domain.match_details"
}

dependencies {
    implementation(projects.domain.common)
}