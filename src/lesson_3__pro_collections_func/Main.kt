package lesson_3__pro_collections_func

import kotlin.math.roundToInt

fun main() {
//    partitionLesson()
    flattenLesson()
//    zipLesson()
//    windowedLesson()
}

// разделение списка по условию:
fun partitionLesson() {
    val numbers = listOf(1, 2, 3, 4, 5, 6)

    val (even, odd) = numbers.partition { it % 2 == 0 }

    println("Четные: $even")   // [2, 4, 6]
    println("Нечетные: $odd")  // [1, 3, 5]
}


// flatten и flatMap — работа со вложенными коллекциями:
fun flattenLesson() {
    val nestedList = listOf(
        listOf(1, 2, 3),
        listOf(4, 5),
        listOf(6, 7, 8, 9)
    )

    // flatten: просто "расплющивает" вложенные списки
    val flattened = nestedList.flatten()
    println(flattened) // [1, 2, 3, 4, 5, 6, 7, 8, 9]

    // flatMap: трансформация + flatten
    val words = listOf("hello", "world")
    val letters = words.flatMap { it.toList() }
    println(letters) // [h, e, l, l, o, w, o, r, l, d]

    // Практический пример
    val sentences = listOf(
        "Kotlin is great",
        "Android development is great"
    )
    val uniqueWords = sentences
        .flatMap { it.split(" ") }
        .distinct()
    println(uniqueWords) // [Kotlin, is, great, Android, development]
}


// zip и zipWithNext — объединение коллекций:
fun zipLesson() {
    val names = listOf("Alice", "Bob", "Charlie")
    val ages = listOf(25, 30, 35)

    // zip: создает пары из двух списков
    val nameAgePairs = names.zip(ages)
    println(nameAgePairs) // [(Alice, 25), (Bob, 30), (Charlie, 35)]

    // zip с трансформацией
    val descriptions = names.zip(ages) { name, age ->
        "$name is $age years old"
    }
    println(descriptions)
    // [Alice is 25 years old, Bob is 30 years old, Charlie is 35 years old]

    // zipWithNext: пары соседних элементов
    val numbers = listOf(1, 2, 3, 4, 5)
    val differences = numbers.zipWithNext { a, b -> b - a }
    println(differences) // [1, 1, 1, 1]

    // Практический пример: вычисление изменений цен
    val prices = listOf(100.0, 105.0, 103.0, 108.0)
    val changes = prices.zipWithNext { prev, curr ->
        ((curr - prev) / prev * 100).roundToInt()
    }
    println("Изменения цен (%): $changes") // [5, -2, 5]
}


// windowed — скользящее окно:
fun windowedLesson() {
    val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    // windowed: создает "окна" фиксированного размера
    val windows = numbers.windowed(size = 3, step = 1)
    println(windows)
    // [[1, 2, 3], [2, 3, 4], [3, 4, 5], [4, 5, 6], ...]

    // Практический пример: скользящее среднее
    val movingAverage = numbers.windowed(3, 1) { window ->
        window.average()
    }
    println("Скользящее среднее: $movingAverage")
    // [2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0]

    // Пример с частичными окнами (partialWindows = true) - включает элемент даже если у него нет полного окна
    val allWindows = numbers.windowed(3, 1, partialWindows = true)
    println("Все окна: $allWindows")
    // последнее окно будет [9, 10], а элемент [10]
}