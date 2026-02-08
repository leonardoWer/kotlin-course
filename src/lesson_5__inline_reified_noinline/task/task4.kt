package lesson_5__inline_reified_noinline.task

/**
 * Задача 19: Создай функцию retry, которая повторяет операцию указанное количество раз при возникновении исключения:
 *
 * - Функция должна быть inline
 * - Использовать crossinline для блока операции
 * - Поддерживать параметры: maxRetries, delay между попытками
 * - Возвращать результат первой успешной попыки или бросать последнее исключение
 */
fun main() {
    val result = retry(
        maxRetries = 3,
        delayMillis = 1000
    ) {
        // Может бросить исключение
        performUnreliableOperation()
    }
    println("Результат: $result")
}

fun performUnreliableOperation(): String {
    val random = (1..10).random()
    if (random <= 7) {
        throw RuntimeException("Случайная ошибка! Выпало число: $random")
    }
    return "Успех! Выпало число: $random"
}

inline fun retry(
    maxRetries: Int = 1,
    delayMillis: Long = 0,
    crossinline operation: () -> Unit
) {
    var lastException: Throwable? = null

    for (attempt in 1..maxRetries) {
        try {
            return operation()
        } catch (e: Throwable) {
            lastException = e

            if (attempt < maxRetries && delayMillis > 0) {
                try {
                    Thread.sleep(delayMillis)
                } catch (ie: InterruptedException) {
                    Thread.currentThread().interrupt()
                    throw ie
                }
            }
        }
    }

    // Попыток не осталось
    throw lastException ?: RuntimeException("Неизвестная ошибка")
}