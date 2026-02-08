package lesson_4__lazy_calc.task

/**
 * Задача 15: Преобразуй цепочку операций над списком в Sequence
 * и объясни, сколько элементов будет обработано на каждом шаге:
 *
 * val numbers = (1..100).toList()
 * val result = numbers
 *     .filter { it % 2 == 0 }
 *     .map { it * 2 }
 *     .filter { it > 50 }
 *     .take(3)
 *     .toList()
 *
 * Вопрос: сколько раз выполнится каждая операция?
 */
fun main() {
    val numbers = (1..100).toList()
    val result = numbers.asSequence()
         .filter {
             println("First filter")
             it % 2 == 0
         }
         .map {
             println("Map")
             it * 2
         }
         .filter {
             println("Second filter")
             it > 50
         }
         .take(3)
         .toList()

    println(
        result
    )
}