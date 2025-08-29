plugins {
    alias(libs.plugins.tennisapp.android.library)
    alias(libs.plugins.tennisapp.android.library.compose)
    alias(libs.plugins.tennisapp.hilt)
}


android {
    namespace = "com.glacierpower.tennisapp.features.ranking"

    buildFeatures {
        buildConfig = true
        viewBinding = true
    }
}


dependencies {
    implementation(projects.domain.ranking)
    implementation(projects.domain.common)
    implementation(projects.core.network)

    implementation(libs.androidx.recyclerview)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.lottie)

    // TODO move it to script
    implementation(libs.androidx.fragment.ktx)
    implementation(libs.androidx.activity.ktx)
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)

}
