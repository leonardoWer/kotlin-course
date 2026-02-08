package lesson_4__lazy_calc

fun main() {
    compareLesson()
    sequenceExample()
    practiseSeqExample()
}

fun compareLesson() {
    val numbers = (1..1_000_000).toList()

    // 1. Обычные коллекции
    val result1 = numbers
        .filter {
            println("Фильтруем: $it")
            it % 2 == 0
        }
        .map {
            println("Преобразуем: $it")
            it * 2
        }
        .take(3)

    println("Результат 1: $result1")
    // Выведет много строк, т.к. обработает весь миллион элементов

    println("---")

    // 2. Sequence (lazy evaluation)
    val result2 = numbers.asSequence()
        .filter {
            println("Sequence фильтруем: $it")
            it % 2 == 0
        }
        .map {
            println("Sequence преобразуем: $it")
            it * 2
        }
        .take(3)
        .toList()

    println("Результат 2: $result2")
    // Выведет только несколько строк, обработает элементы по мере необходимости
}


fun sequenceExample() {
    // 👍 Хороший случай для Sequence: длинные цепочки операций
    val largeList = (1..10_000_000).toList()

    val sequenceResult = largeList.asSequence()
        .filter { it % 3 == 0 }
        .map { it * 2 }
        .filter { it > 1000 }
        .take(10)
        .toList()

    // 👎 Плохой случай: мало элементов или простая операция
    val smallList = listOf(1, 2, 3, 4, 5)
    val listResult = smallList
        .filter { it % 2 == 0 }
        .map { it * 2 }
    // Sequence здесь не нужен - только добавит накладные расходы

    // Особые случаи:
    val infiniteSequence = generateSequence(1) { it + 1 }
    val first10 = infiniteSequence.take(10).toList()
    println(first10) // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

    // Генерация последовательности с условием
    val sequenceUntil100 = generateSequence(1) {
        if (it < 100) it * 2 else null
    }.toList()
    println(sequenceUntil100) // [1, 2, 4, 8, 16, 32, 64, 128]
}


fun practiseSeqExample() {
    data class User(val name: String, val age: Int, val city: String)

    val users = listOf(
        User("Alice", 25, "Moscow"),
        User("Bob", 30, "SPb"),
        User("Charlie", 22, "Moscow"),
        User("David", 35, "SPb"),
        User("Eve", 28, "Moscow")
    )

    // Без Sequence (обрабатываем всех пользователей)
    val result1 = users
        .filter {
            println("Фильтруем по городу: ${it.name}")
            it.city == "Moscow"
        }
        .filter {
            println("Фильтруем по возрасту: ${it.name}")
            it.age > 25
        }
        .map {
            println("Получаем имя: ${it.name}")
            it.name
        }
        .firstOrNull()

    println("Первый подходящий: $result1")

    println("---")

    // С Sequence (ленивые вычисления)
    val result2 = users.asSequence()
        .filter {
            println("Sequence фильтруем по городу: ${it.name}")
            it.city == "Moscow"
        }
        .filter {
            println("Sequence фильтруем по возрасту: ${it.name}")
            it.age > 25
        }
        .map {
            println("Sequence получаем имя: ${it.name}")
            it.name
        }
        .firstOrNull()

    println("Первый подходящий (sequence): $result2")
}