package lesson_5__inline_reified_noinline.task

import kotlin.concurrent.thread

/**
 * Задача 18: Объясни, почему в этой функции нужен crossinline:
 *
 * inline fun doAsync(crossinline block: () -> Unit) {
 *     thread {
 *         try {
 *             block()
 *         } catch (e: Exception) {
 *             e.printStackTrace()
 *         }
 *     }
 * }
 */
fun main() {
    doAsyncIncorrect {
        for (i in 1..10) {
            if (i < 5)
                println(i)
            else return@doAsyncIncorrect
        }
    }
}

inline fun doAsyncIncorrect(crossinline block: () -> Unit) {
    thread {
         try {
             block()
         } catch (e: Exception) {
             e.printStackTrace()
         }
    }
}