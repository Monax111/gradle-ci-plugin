tasks {
    val tim = register("tim") {
        group = "demo"
        println("Настройка таски $name")

        actions.add(Action {
            println("Действие таски $name")
        })

        doFirst {

            println("Перед действий таски $name")

        }
        doLast {
            println("После действий таски $name")
        }
    }

    register("foo") {
        group = "demo"
        actions.add(Action {
            println("Действие таски $name")
        })
        dependsOn(tim)
        mustRunAfter(tim)
        shouldRunAfter(tim)
        //finalizedBy(tim)
    }
}

println("Настраиваем билд")