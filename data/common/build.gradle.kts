plugins {
    alias(libs.plugins.tennisapp.android.library)
    alias(libs.plugins.tennisapp.hilt)
    alias(libs.plugins.tennisapp.android.library.detekt)
}

android {
    namespace = "com.glacierpower.tennisapp.data.common"
}

dependencies{
    implementation(projects.core.network)
    implementation(projects.domain.common)

    implementation(libs.kotlin.serialization.json)
}