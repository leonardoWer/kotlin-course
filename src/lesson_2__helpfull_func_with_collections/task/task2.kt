package lesson_2__helpfull_func_with_collections.task

/**
 * Задача 8: Создай функцию, которая объединяет две мапы.
 * Если ключ есть в обеих мапах, складывай значения.
 *
 * Вход:
 * map1 = {"a" to 1, "b" to 2}
 * map2 = {"b" to 3, "c" to 4}
 * Ожидаемый вывод: {"a"=1, "b"=5, "c"=4}
 */
fun main() {
    println(unionMaps(mapOf("a" to 1, "b" to 2), mapOf("b" to 3, "c" to 4)))
}

fun unionMaps(map1: Map<String, Int>, map2: Map<String, Int>): Map<String, Int> {
    val res = map1.toMutableMap()

    for ((key, value) in map2) {
        res[key] = res.getOrPut(key) { 0 } + value
    }

    return res
}


fun perfectSolution() {
    fun unionMaps(map1: Map<String, Int>, map2: Map<String, Int>): Map<String, Int> {
        return (map1.asSequence() + map2.asSequence())
            .groupBy({ it.key }, { it.value })
            .mapValues { (_, values) -> values.sum() }
    }
}