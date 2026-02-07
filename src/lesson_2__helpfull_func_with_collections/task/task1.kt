package lesson_2__helpfull_func_with_collections.task

/**
 * Задача 7: Напиши функцию, которая принимает список слов
 * и возвращает Map, где ключ — длина слова, а значение — список слов такой длины.
 *
 * Вход: ["cat", "dog", "elephant", "bird", "lion"]
 * Ожидаемый вывод: {
 *   3 = ["cat", "dog"],
 *   8 = ["elephant"],
 *   4 = ["bird", "lion"]
 * }
 */
fun main() {
    println(getLengthWordListMap(listOf("cat", "dog", "elephant", "bird", "lion")))
}

fun getLengthWordListMap(values: List<String>): Map<Int, List<String>> {
    return values.groupBy { it.length }
}