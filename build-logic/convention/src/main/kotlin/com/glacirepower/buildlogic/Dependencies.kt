package com.glacirepower.buildlogic

import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

internal fun Project.configureBaseDependencies(){
    val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

    dependencies{
        add("implementation", libs.findLibrary("timber").get())
    }
}