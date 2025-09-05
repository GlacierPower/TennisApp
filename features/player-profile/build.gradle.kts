plugins {
    alias(libs.plugins.tennisapp.android.library)
    alias(libs.plugins.tennisapp.android.library.compose)
    alias(libs.plugins.tennisapp.hilt)
    alias(libs.plugins.tennisapp.android.library.fragment)
    alias(libs.plugins.tennisapp.android.library.detekt)
}

android {
    namespace = "com.glacierpower.tennisapp.features.player_profile"
}

dependencies {
    implementation(projects.core.ui)
    implementation(projects.core.designSystem)

    implementation(projects.domain.common)
    implementation(projects.domain.playerProfile)
}
