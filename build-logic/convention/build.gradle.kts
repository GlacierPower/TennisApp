import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    `kotlin-dsl`
}

group = "com.glacierpower.tennisapp"

java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}

kotlin {
    compilerOptions {
        jvmTarget = JvmTarget.JVM_21
    }
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.kotlin.compose.gradlePlugin)
    compileOnly(libs.ksp.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "tennisapp.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("ansdroidLibrary") {
            id = ""
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("hilt") {
            id = "tennisapp.hilt"
            implementationClass = "HiltConventionPlugin"
        }

    }
}