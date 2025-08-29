import com.android.build.api.dsl.LibraryExtension
import com.glacirepower.buildlogic.configureAndroidCompose
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.getByType

class AndroidComposeLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project): Unit = with(target) {
        apply(plugin = "com.android.library")
        apply(plugin = "org.jetbrains.kotlin.plugin.compose")
        configureAndroidCompose(extensions.getByType<LibraryExtension>())
    }
}
