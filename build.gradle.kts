tasks {
    register("tim") {
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
}

println("Настраиваем билд")