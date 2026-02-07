package lesson_1__lambda_higher_order_functions.task

/**
 * Задача 6: С помощью fold преобразуй список пар (ключ-значение)
 * в Map<String, List<Int>>,
 * где ключ — это первая буква строки,
 * а значения — длины строк, начинающихся на эту букву.
 *
 * Вход: ["apple", "apricot", "banana", "blueberry", "cherry"]
 * Ожидаемый вывод: {
 *   "a" = [5, 7],
 *   "b" = [6, 9],
 *   "c" = [6]
 * }
 */
fun main() {
    println(getStrLengthMap(listOf("apple", "apricot", "banana", "blueberry", "cherry")))
}

fun getStrLengthMap(values: List<String>): Map<String, List<Int>>? {
    if (values.isEmpty()) return null

    return values.fold(mutableMapOf<String, MutableList<Int>>()) { map, word ->
        val firstLetter = word.first().toString()

        val lengths = map.getOrPut(firstLetter) { mutableListOf() }

        lengths.add(word.length)

        map
    }
}

