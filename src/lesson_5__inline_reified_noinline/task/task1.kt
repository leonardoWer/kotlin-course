package lesson_5__inline_reified_noinline.task

/**
 * Задача 16: Создай inline-функцию measureTime,
 * которая измеряет время выполнения блока кода и выводит его.
 *
 * Используй System.nanoTime().
 */
fun main() {
    val (result, time) = measureTime {
        (1..100000).sum()
    }
    println("Результат: $result, время: ${time / 1_000_000} мс")
}

inline fun <T> measureTime(block: () -> T): Pair<T, Long> {
    val startTime = System.nanoTime()
    val result = block()
    val duration = System.nanoTime() - startTime
    return result to duration
}