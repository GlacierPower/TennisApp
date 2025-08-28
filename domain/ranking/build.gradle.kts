plugins {
    alias(libs.plugins.tennisapp.android.library)
    alias(libs.plugins.tennisapp.hilt)
}

android {
    namespace = "com.glacierpower.tennisapp.domain.ranking"
}

dependencies{
    implementation(projects.domain.common)
}