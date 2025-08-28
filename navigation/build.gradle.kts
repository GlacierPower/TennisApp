plugins {
    alias(libs.plugins.tennisapp.android.library)
}

android {
    namespace = "com.tennisapp.navigation"
}

dependencies {
    implementation(projects.features.ranking)
}