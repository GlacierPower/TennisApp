import com.android.build.api.dsl.ApplicationExtension
import com.glacirepower.buildlogic.Constants
import com.glacirepower.buildlogic.configureBaseDependencies
import com.glacirepower.buildlogic.configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
            }

            extensions.configure<ApplicationExtension> {
                defaultConfig.targetSdk = Constants.TARGET_SDK

                bundle {
                    language {
                        enableSplit = false
                    }
                }

                configureKotlinAndroid(this)
                configureBaseDependencies()
            }
        }
    }
}