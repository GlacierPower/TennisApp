plugins {
    alias(libs.plugins.tennisapp.android.library)
    alias(libs.plugins.tennisapp.hilt)
    alias(libs.plugins.tennisapp.android.library.compose)
    alias(libs.plugins.tennisapp.android.library.detekt)
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "com.glacierpower.tennisapp.navigation"
}

dependencies {
    implementation(libs.nav3.ui)
    implementation(libs.nav3.runtime)
    implementation(libs.androidx.lifecycle.viewmodel.nav3)
    implementation(libs.androidx.hilt.navigation.compose)

    implementation(projects.core.ui)
    implementation(projects.features.ranking)
    implementation(projects.features.playerProfile)
}