tasks {

    val tim = register<MyTask>("tim") {
        group = "demo"
        println("Настройка таски $name")

        doFirst {

            println("Перед действий таски $name")

        }
        doLast {
            println("После действий таски $name")
        }
    }

    register<MyTask>("foo") {
        group = "demo"
        dependsOn(tim)
        mustRunAfter(tim)
        shouldRunAfter(tim)
        //finalizedBy(tim)
    }


}

println("Настраиваем билд")

open class MyTask : DefaultTask() {

    @TaskAction
    fun doIt(){
        println("Действие таски $name")
    }
}