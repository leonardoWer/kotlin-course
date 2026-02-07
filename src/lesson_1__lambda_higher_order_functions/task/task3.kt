package lesson_1__lambda_higher_order_functions.task

/**
 * Используя fold, посчитайте произведение всех чисел в списке.
 *
 * Вход: [1, 2, 3, 4]
 * Ожидаемый вывод: 24
 */
fun main() {
    val composition: (List<Int>) -> Int = {
        it.fold(1) { currentValue, item -> currentValue * item}
    }

    println(composition(listOf(1, 2, 3, 4)))
}