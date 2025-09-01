plugins {
    alias(libs.plugins.tennisapp.android.library)
    alias(libs.plugins.tennisapp.hilt)
}

android {
    namespace = "com.glacierpower.tennisapp.domain.player_profile"
}

dependencies {
    implementation(projects.domain.common)
}