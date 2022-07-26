this::class.java.declaredMethods.forEach {
    println(it)
}

println(this::class.java.superclass)

project.apply{

    tasks.forEach {
        println(it)
    }

}