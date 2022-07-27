package ru.tim.demo.ci.gradle

import java.io.File
import java.nio.file.Files
import java.util.stream.Collectors
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.InputDirectory
import org.gradle.api.tasks.TaskAction

open class VerifyLogic : DefaultTask() {

    init {
        group = "verification"
    }

    @InputDirectory
    var dir: File = project.projectDir.resolve("src/main/kotlin")

    @Input
    var filter: java.nio.file.Path.() -> Boolean = { toString().contains("controller") }

    @Input
    val restrictedFrame = mutableSetOf("if", "when")

    @TaskAction
    fun verify() {
        val files = Files.walk(dir.toPath())
            .filter {
                Files.isRegularFile(it) && it.filter()
            }.filter {
                project.logger.quiet("Анализируем $it")
                val text = it.toFile().readText()
                restrictedFrame.any { text.contains(it) }
            }.collect(Collectors.toList())

        if (files.isNotEmpty()) {
            throw RuntimeException("Найдены недопустимые фрагменты в файлах" +
                files.joinToString(System.lineSeparator()) { it.toString() })
        }
    }


}
