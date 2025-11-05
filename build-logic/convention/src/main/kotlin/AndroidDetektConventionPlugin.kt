import com.glacirepower.buildlogic.configureDetekt
import org.gradle.api.Plugin
import org.gradle.api.Project

class AndroidDetektConventionPlugin : Plugin<Project> {
    override fun apply(target: Project): Unit = with(target) {
        pluginManager.apply("io.gitlab.arturbosch.detekt")
        configureDetekt()
    }
}