import com.android.build.gradle.LibraryExtension
import com.glacirepower.buildlogic.configureBaseDependencies
import com.glacirepower.buildlogic.configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType

class AndroidLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.library")
                apply("kotlin-android")
            }

            with(extensions.getByType<LibraryExtension>()) {
                configureKotlinAndroid(this)
                configureBaseDependencies()
            }
        }
    }
}