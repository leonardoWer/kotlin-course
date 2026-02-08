package lesson_5__inline_reified_noinline.task

/**
 * Задача 17: Создай функцию с reified типом,
 * которая принимает список и возвращает только элементы определенного типа:
 *
 * Вход: listOf(1, "Hello", 2.5, "World", 3)
 * Вызов: filterByType<String>()
 * Ожидаемый вывод: ["Hello", "World"]
 */
fun main() {
    println(
        filterByType<String>(listOf(1, "Hello", 2.5, "World", 3))
    )
}


inline fun <reified T> filterByType(values: List<Any>): List<T> {
    return values.filter { it is T } as List<T>
}