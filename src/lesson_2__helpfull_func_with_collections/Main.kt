package lesson_2__helpfull_func_with_collections

fun main() {
    lessonMap()
    lessonGetOr()
    lessonGroupBy()
}

fun lessonMap() {
    // Создание мапы
    val map1 = mapOf("a" to 1, "b" to 2) // неизменяемая
    val map2 = mutableMapOf("a" to 1, "b" to 2) // изменяемая

    // Доступ к элементам
    println(map1["a"]) // 1
    println(map1.getOrDefault("c", 0)) // 0

    // Добавление/обновление
    map2["c"] = 3
    map2.put("d", 4)

    // Итерация
    for ((key, value) in map2) {
        println("$key -> $value")
    }

    // Полезные функции
    val filteredMap = map2.filter { (key, value) -> value > 2 }
    println(filteredMap) // {c=3, d=4}

    val transformed = map2.mapValues { (_, value) -> value * 2 }
    println(transformed) // {a=2, b=4, c=6, d=8}
}

fun lessonGetOr() {
    val wordCounts = mutableMapOf<String, Int>()

    // getOrPut: если ключа нет - добавляет с вычисленным значением
    wordCounts["hello"] = wordCounts.getOrPut("hello") { 0 } + 1
    wordCounts["hello"] = wordCounts.getOrPut("hello") { 0 } + 1
    wordCounts["world"] = wordCounts.getOrPut("world") { 0 } + 1

    println(wordCounts) // {hello=2, world=1}

    // getOrElse: если ключа нет - возвращает результат лямбды
    val count = wordCounts.getOrElse("kotlin") {
        println("Ключ не найден!")
        -1
    }
    println(count) // "Ключ не найден!" затем -1
}

fun lessonGroupBy() {
    val words = listOf("apple", "apricot", "banana", "blueberry", "cherry")

    // groupBy: автоматически группирует по ключу
    val groupedByFirstLetter = words.groupBy { it.first().toString() }
    println(groupedByFirstLetter)
    // {a=[apple, apricot], b=[banana, blueberry], c=[cherry]}

    // groupBy с трансформацией значений
    val groupedByLength = words.groupBy(
        keySelector = { it.length },
        valueTransform = { it.uppercase() }
    )
    println(groupedByLength)
    // {5=[APPLE], 7=[APRICOT], 6=[BANANA, CHERRY], 9=[BLUEBERRY]}

    // Сразу получаем длины слов
    val lengthMap = words.groupBy({ it.first().toString() }, { it.length })
    println(lengthMap)
    // {a=[5, 7], b=[6, 9], c=[6]}
}