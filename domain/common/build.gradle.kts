plugins {
    alias(libs.plugins.tennisapp.android.library)
    alias(libs.plugins.tennisapp.hilt)
}

android {
    namespace = "com.glacierpower.tennisapp.domain.common"
}

dependencies {
    implementation(projects.core.network)
}