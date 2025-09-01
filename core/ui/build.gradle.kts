plugins {
    alias(libs.plugins.tennisapp.android.library)
    alias(libs.plugins.tennisapp.android.library.compose)
    alias(libs.plugins.tennisapp.hilt)
    alias(libs.plugins.tennisapp.android.library.fragment)
}

android {
    namespace = "com.glacierpower.tennisapp.core.ui"
}