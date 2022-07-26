tasks.forEach {
    println(it)
}

afterEvaluate {
    println("after")
}

extensions.extensionsSchema.forEach {
    println(it.name)
}

version = 23
group = "ru.tim"

logger.error("Logger")
