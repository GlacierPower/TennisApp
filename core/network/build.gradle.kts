import java.util.Properties

plugins {
    alias(libs.plugins.tennisapp.android.library)
    alias(libs.plugins.tennisapp.hilt)
    alias(libs.plugins.tennisapp.android.library.detekt)
    alias(libs.plugins.kotlin.serialization)
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
        val countryFlagKey = "COUNTRY_FLAG_KEY"
        val localProperties = Properties().apply {
            load(rootProject.file(path).inputStream())
        }

        buildConfigField(
            type = type,
            name = name,
            value = "\"${localProperties.getProperty(name)}\""
        )
        buildConfigField(
            type = type,
            name = countryFlagKey,
            value = "\"${localProperties.getProperty(countryFlagKey)}\""
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
    implementation("com.fasterxml.jackson.core:jackson-databind:2.18.0")
}
