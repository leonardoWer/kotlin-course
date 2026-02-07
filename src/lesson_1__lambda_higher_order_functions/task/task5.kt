package lesson_1__lambda_higher_order_functions.task

/**
 * Задача 5: Используя fold, посчитай среднее арифметическое чисел в списке. Учти пустой список.
 *
 * Вход: [5.0, 10.0, 15.0, 20.0]
 * Ожидаемый вывод: 12.5
 */
fun main() {
    println(getMiddleValue(listOf(5.0, 10.0, 15.0, 20.0)))
}

fun getMiddleValue(values: List<Double>): Double? {
    if (values.isEmpty()) return null

    val res = values.fold(0.0) { totalSum, curValue ->
        (totalSum + curValue)
    }

    return res / values.size
}