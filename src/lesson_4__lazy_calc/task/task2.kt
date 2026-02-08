package lesson_4__lazy_calc.task

/**
 * Задача 14: Есть большой список транзакций.
 * С помощью Sequence оптимизируй поиск первой транзакции определенного типа с суммой больше заданной.
 *
 * Вход: список из 1_000_000 транзакций (Transaction(type, amount))
 * Найти: первую транзакцию типа "CREDIT" с amount > 5000
 */
fun main() {}

data class Transaction(
    val type: String,
    val amount: Int
)

fun findFirstSum(values: List<Transaction>, type: String, minAmount: Int): Transaction? {
    return values.asSequence()
        .filter { it.type == type }
        .firstOrNull { it.amount > minAmount }
}