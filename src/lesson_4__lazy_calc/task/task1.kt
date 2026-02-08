package lesson_4__lazy_calc.task

/**
 *Задача 13: Создай бесконечную последовательность чисел Фибоначчи с помощью generateSequence.
 * Найди первое число в последовательности, которое больше 1000.
 */
fun main() {
    println(
        generateFibAndTakeFirst { it > 1000 }
    )
}

fun generateFibAndTakeFirst(condition: (Int) -> Boolean): List<Int> {
    var curFib = 0
    return generateSequence(1) {
        val r = it + curFib
        curFib = it
        r
    }
        .filter(condition)
        .take(1)
        .toList()
}


fun perfectSolution() {
    fun generateFibAndTakeFirst(condition: (Int) -> Boolean): Int {
        return generateSequence(Pair(0, 1)) { Pair(it.second, it.first + it.second) }
            .map { it.first }
            .first(condition)
    }
}