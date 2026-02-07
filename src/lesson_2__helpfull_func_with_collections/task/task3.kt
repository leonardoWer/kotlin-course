package lesson_2__helpfull_func_with_collections.task

/**
 * Задача 9: Используя mapValues, преобразуй мапу температур из Цельсия в Фаренгейты (формула: °F = °C × 9/5 + 32).
 *
 * text
 * Вход: {"Monday" to 20, "Tuesday" to 22, "Wednesday" to 18}
 * Ожидаемый вывод: {"Monday"=68.0, "Tuesday"=71.6, "Wednesday"=64.4}
 */
fun main() {
    println(transformCelseToFarengate(mapOf("Monday" to 20, "Tuesday" to 22, "Wednesday" to 18)))
}

fun transformCelseToFarengate(tempMap: Map<String, Int>): Map<String, Double> =
    tempMap.mapValues{ (_, value) -> value.toDouble() * (9/5) + 32 }