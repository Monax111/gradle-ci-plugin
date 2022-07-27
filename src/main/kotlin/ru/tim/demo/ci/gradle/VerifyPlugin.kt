package ru.tim.demo.ci.gradle

import org.gradle.api.Plugin
import org.gradle.api.Project
import ru.tim.demo.ci.gradle.task.VerifyLogic

class VerifyPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        val verify = target.tasks.register("verifyLogic", VerifyLogic::class.java)
        
        target.pluginManager.withPlugin("java"){
            verify.configure{
                shouldRunAfter(target.tasks.named("test"))
            }

        }
    }
}