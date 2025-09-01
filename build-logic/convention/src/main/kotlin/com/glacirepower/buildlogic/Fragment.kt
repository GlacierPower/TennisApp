package com.glacirepower.buildlogic

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

fun Project.configureAndroidFragment(extension: CommonExtension<*, *, *, *, *, *>) {
    val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

    extension.apply {
        buildFeatures {
            viewBinding = true
            buildConfig = true
        }
    }

    dependencies {
        "implementation"(libs.findLibrary("androidx-recyclerview").get())
        "implementation"(libs.findLibrary("androidx-lifecycle-viewmodel-ktx").get())
        "implementation"(libs.findLibrary("androidx-core-ktx").get())
        "implementation"(libs.findLibrary("androidx-appcompat").get())
        "implementation"(libs.findLibrary("material").get())
        "implementation"(libs.findLibrary("androidx-constraintlayout").get())
        "implementation"(libs.findLibrary("lottie").get())
        "implementation"(libs.findLibrary("androidx-fragment-ktx").get())
        "implementation"(libs.findLibrary("androidx-activity-ktx").get())
        "implementation"(libs.findLibrary("androidx-lifecycle-livedata-ktx").get())
        "implementation"(libs.findLibrary("androidx-lifecycle-runtime-ktx").get())
    }

}