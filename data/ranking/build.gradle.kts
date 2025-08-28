plugins {
    alias(libs.plugins.tennisapp.android.library)
    alias(libs.plugins.tennisapp.hilt)
}

android {
    namespace = "com.tennisapp.data.ranking"
}

dependencies {
    implementation(projects.domain.common)
    implementation(projects.domain.ranking)
    implementation(projects.core.network)
    implementation(projects.data.common)

    implementation(libs.retrofit)
}
