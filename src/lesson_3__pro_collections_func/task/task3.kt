package lesson_3__pro_collections_func.task

/**
 * Задача 12: Используя zipWithNext, найди все интервалы, где температура повышалась 3 дня подряд.
 *
 * Вход: [20, 22, 23, 21, 24, 26, 25, 27]
 * Ожидаемый вывод: [(0-2), (3-5)] // индексы дней, где было повышение 3 дня подряд
 *
 * Подсказка: используй windowed(4) и проверяй, что все разности положительные
 */
fun main() {
    println(getThreeDayThempUpIntervals(listOf(
        20, 22, 23, 21, 24, 26, 25, 27
    )))
}

fun getThreeDayThempUpIntervals(values: List<Int>): List<String> {
    return values.windowed(step = 1, size = 4)
        .mapIndexedNotNull { index, window ->
            val isIncreasing = window
                .take(3)
                .zipWithNext { a, b -> b > a }
                .all { it }

            if (isIncreasing) "($index-${index + 2})" else null
        }
}