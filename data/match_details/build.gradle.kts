plugins {
    alias(libs.plugins.tennisapp.android.library)
    alias(libs.plugins.tennisapp.hilt)
    alias(libs.plugins.tennisapp.android.library.detekt)
}

android {
    namespace = "com.glacierpower.tennisapp.data.match_details"
}

dependencies{
    implementation(projects.domain.common)
    implementation(projects.core.network)
    implementation(projects.data.common)
    implementation(projects.domain.matchDetails)

    implementation(libs.retrofit)
}