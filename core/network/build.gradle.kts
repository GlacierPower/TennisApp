import java.util.Properties

plugins {
    alias(libs.plugins.tennisapp.android.library)
    alias(libs.plugins.tennisapp.hilt)
    alias(libs.plugins.tennisapp.android.library.detekt)
}


android {
    namespace = "com.tennisapp.core.network"

    buildFeatures {
        buildConfig = true
    }
    
    defaultConfig {
        val path = "local.properties"
        val type = "String"
        val name = "API_KEY"
        val localProperties = Properties().apply {
            load(rootProject.file(path).inputStream())
        }

        buildConfigField(
            type = type,
            name = name,
            value = "\"${localProperties.getProperty(name)}\""
        )
    }
}

dependencies {
    implementation(libs.retrofit)
    implementation(libs.kotlin.serialization.json)
    implementation(libs.logging.interceptor)
    implementation(libs.converter.moshi)
    implementation(libs.converter.gson)
    implementation(libs.moshi.kotlin)
}
