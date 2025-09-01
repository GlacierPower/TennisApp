package com.glacirepower.buildlogic

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.kotlin.compose.compiler.gradle.ComposeCompilerGradlePluginExtension

fun Project.configureAndroidCompose(extension: CommonExtension<*, *, *, *, *, *>) {
    val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

    extension.apply {
        buildFeatures {
            compose = true
        }
    }

    with(extensions.getByType<ComposeCompilerGradlePluginExtension>()) {
        includeSourceInformation.set(true)
        reportsDestination.set(layout.buildDirectory.dir("compose_compiler"))
    }

    dependencies {
        val bom = libs.findLibrary("androidx-compose-bom").get()
        "implementation"(platform(bom))
        "androidTestImplementation"(platform(bom))
        "implementation"(libs.findLibrary("androidx-compose-bom").get())
        "implementation"(libs.findLibrary("androidx-compose-material3").get())
        "implementation"(libs.findLibrary("androidx-compose-viewmodel").get())
        "implementation"(libs.findLibrary("androidx-compose-activity").get())
        "implementation"(libs.findLibrary("androidx-compose-preview").get())
        "implementation"(libs.findLibrary("androidx-compose-foundation").get())
        "implementation"(libs.findLibrary("androidx-hilt-navigation-compose").get())
    }
}
