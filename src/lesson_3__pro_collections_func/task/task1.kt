package lesson_3__pro_collections_func.task

/**
 * Задача 10: Используя partition, раздели список продуктов на две категории: дорогие (>= 1000) и дешевые.
 *
 * Вход: listOf(
 *     Product("Phone", 1500),
 *     Product("Book", 300),
 *     Product("Headphones", 800),
 *     Product("Laptop", 2000)
 * )
 * Ожидаемый вывод:
 * Дорогие: [Phone(1500), Laptop(2000)]
 * Дешевые: [Book(300), Headphones(800)]
 */
fun main() {
    println(splitProductLists(listOf(
        Product("Phone", 1500),
        Product("Book", 300),
        Product("Headphones", 800),
        Product("Laptop", 2000))))
}

fun splitProductLists(productsList: List<Product>): List<List<Product>> {
    val (expensiveProducts, budgetProducts) = productsList.partition { it.price >= 1000 }
    return listOf(expensiveProducts, budgetProducts)
}

data class Product(
    val name: String = "",
    val price: Int = 0
)