package lesson_1__lambda_higher_order_functions.task

/**
Задача 1:
Напишите лямбду, которая принимает строку и возвращает её длину. Примените её к списку строк

Вход: ["Kotlin", "Android", "Jetpack"]
Ожидаемый вывод: [6, 7, 7]
*/

fun main() {
    val getStrName: (String) -> Int = { it.length }

    listOf("Kotlin", "Android", "Jetpack").forEach { println(getStrName(it)) }
}


fun perfectSolution1() {
    val strings = listOf("Kotlin", "Android", "Jetpack")
    val lengths = strings.map { it.length }

    println(lengths) // [6, 7, 7]
}