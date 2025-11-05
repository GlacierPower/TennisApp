plugins {
    alias(libs.plugins.tennisapp.android.library)
    alias(libs.plugins.tennisapp.hilt)
    alias(libs.plugins.tennisapp.android.library.detekt)
}

android {
    namespace = "com.glacierpower.tennisapp.data.tournament_details"
}

dependencies {
    implementation(projects.domain.common)
    implementation(projects.domain.tournamentDetails)
    implementation(projects.core.network)
    implementation(projects.data.common)

    implementation(libs.retrofit)
}
