plugins {
    alias(libs.plugins.tennisapp.android.library)
    alias(libs.plugins.tennisapp.android.library.compose)
    alias(libs.plugins.tennisapp.hilt)
    alias(libs.plugins.tennisapp.android.library.detekt)
}

android {
    namespace = "com.glacierpower.tennisapp.features.ranking"
}

dependencies {
    implementation(projects.domain.ranking)
    implementation(projects.domain.common)

    implementation(projects.core.ui)
    implementation(projects.core.network)
    implementation(projects.core.designSystem)
    implementation(libs.coil.compose)
}
