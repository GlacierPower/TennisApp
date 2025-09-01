plugins {
    alias(libs.plugins.tennisapp.android.library)
    alias(libs.plugins.tennisapp.hilt)
}

android {
    namespace = "com.glacierpower.tennisapp.data.player_profile"
}

dependencies{
    implementation(projects.domain.common)
    implementation(projects.domain.playerProfile)
    implementation(projects.core.network)
    implementation(projects.data.common)

    implementation(libs.retrofit)
}