package lesson_1__lambda_higher_order_functions

fun main() {
    val numbers = listOf(1, 2, 3, 4, 5)

    // 1. Лямбда в переменной
    val square: (Int) -> Int = { it * it }
    println(square(5)) // 25

    // 2. Передача лямбды в функцию высшего порядка
    val doubled = numbers.map { it * 2 }
    println(doubled) // [2, 4, 6, 8, 10]

    // 3. Фильтрация
    val evenNumbers = numbers.filter { it % 2 == 0 }
    println(evenNumbers) // [2, 4]

    // 4. Своя функция высшего порядка
    fun processNumbers(nums: List<Int>, processor: (Int) -> Int): List<Int> {
        return nums.map(processor)
    }

    val result = processNumbers(numbers) { it + 10 }
    println(result) // [11, 12, 13, 14, 15]


    // fold

    // Сумма с начальным значением 0
    val sum = numbers.fold(0) { acc, num -> acc + num }
    println(sum) // 10

    // Произведение с начальным значением 1
    val product1 = numbers.fold(1) { acc, num -> acc * num }
    println(product1) // 24

    // fold может менять тип! Например, строим строку:
    val stringResult = numbers.fold("Числа: ") { str, num -> "$str$num " }
    println(stringResult) // "Числа: 1 2 3 4 "

    // Работа с нечисловыми типами
    val words = listOf("Kotlin", "is", "awesome")
    val totalLength = words.fold(0) { length, word -> length + word.length }
    println(totalLength) // 13 (6 + 2 + 5)

    println(findMax(listOf(3, 7, 2, 9, 1)))

    // reduce

    // Произведение через reduce
    val product2 = numbers.reduce { acc, num -> acc * num }
    println(product2) // 24

    // Сравнение: fold vs reduce на пустом списке
    val emptyList = emptyList<Int>()

    val foldResult = emptyList.fold(0) { acc, num -> acc + num }
    println(foldResult) // 0 (без ошибки)

    // val reduceResult = emptyList.reduce { acc, num -> acc + num } // RuntimeException!
}

// Поиск максимального элемента с fold
fun findMax(numbers: List<Int>): Int? {
    if (numbers.isEmpty()) return null
    return numbers.fold(numbers[0]) { max, num ->
        if (num > max) num else max
    }
}