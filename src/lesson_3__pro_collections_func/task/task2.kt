package lesson_3__pro_collections_func.task

/**
 *Задача 11: С помощью flatMap преобразуй список заказов в список всех уникальных товаров.
 *
 * Вход: listOf(
 *     Order(listOf("Apple", "Banana", "Orange")),
 *     Order(listOf("Banana", "Milk")),
 *     Order(listOf("Apple", "Bread", "Milk"))
 * )
 * Ожидаемый вывод: [Apple, Banana, Orange, Milk, Bread]
 */
fun main() {
    println(getUniqueOrders(listOf(
        Order(listOf("Apple", "Banana", "Orange")),
        Order(listOf("Banana", "Milk")),
        Order(listOf("Apple", "Bread", "Milk"))
    )))
}

fun getUniqueOrders(orders: List<Order>): List<String> {
    return orders
        .flatMap { it.ordersList }
        .distinct()
}

data class Order(
    val ordersList: List<String> = emptyList()
)