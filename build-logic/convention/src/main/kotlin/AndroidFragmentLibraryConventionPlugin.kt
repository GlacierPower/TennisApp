import com.android.build.api.dsl.LibraryExtension
import com.glacirepower.buildlogic.configureAndroidFragment
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.apply

class AndroidFragmentLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project): Unit = with(target) {
        apply(plugin = "com.android.library")
        configureAndroidFragment(extensions.getByType<LibraryExtension>())

    }
}