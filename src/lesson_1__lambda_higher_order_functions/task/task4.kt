package lesson_1__lambda_higher_order_functions.task

/**
 * Задача 4: Напиши функцию, которая принимает список строк и возвращает самую длинную строку, используя fold.
 *
 * Вход: ["Java", "Kotlin", "Python", "C++"]
 * Ожидаемый вывод: "Python"
 */
fun main() {
    println(getMaxLengthStr(listOf("Java", "Kotlin", "Python", "C++")))
}

fun getMaxLengthStr(strings: List<String>): String? {
    if (strings.isEmpty()) return null

    return strings.fold(strings[0]) { maxLengthString, currentString ->
        if (currentString.length > maxLengthString.length) currentString else maxLengthString
    }
}