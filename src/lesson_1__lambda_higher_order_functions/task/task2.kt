package lesson_1__lambda_higher_order_functions.task

/**
 * Задача 2:
 * Создайте функцию filterAndTransform, которая принимает список чисел,
 * функцию-фильтр и функцию-трансформацию.
 * Отфильтруйте список, затем примените трансформацию.
 *
 * Вход: [1, 2, 3, 4, 5], фильтр: { it > 2 }, трансформация: { it * 10 }
 * Ожидаемый вывод: [30, 40, 50]
 */
fun main() {
    println(
        filterAndTransform(listOf(1, 2, 3, 4, 5), { it > 2 }, { it * 10 })
    )
}

fun filterAndTransform(nums: List<Int>, processor: (Int) -> Boolean, transformer: (Int) -> Int): List<Int> {
    val res: MutableList<Int> = mutableListOf()

    nums.forEach {
        if (processor(it)) {
            res.add(transformer(it))
        }
    }

    return res
}



fun perfectSolution2() {
    fun filterAndTransform(nums: List<Int>, filter: (Int) -> Boolean, transform: (Int) -> Int): List<Int> {
        return nums.filter(filter).map(transform)
    }
}