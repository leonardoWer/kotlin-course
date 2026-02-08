package lesson_5__inline_reified_noinline

/** Практический пример в Android: */
class View() {

    // Без inline (плохо - создание лишних объектов)
    fun setOnThrottledClickListenerNoI(delay: Long, onClick: () -> Unit) {
        var lastClickTime = 0L
        setOnClickListener {
            val currentTime = System.currentTimeMillis()
            if (currentTime - lastClickTime >= delay) {
                lastClickTime = currentTime
                onClick()
            }
        }
    }

    // С inline (лучше)
    inline fun setOnThrottledClickListenerI(
        delay: Long,
        crossinline onClick: () -> Unit
    ) {
        var lastClickTime = 0L
        setOnClickListener {
            val currentTime = System.currentTimeMillis()
            if (currentTime - lastClickTime >= delay) {
                lastClickTime = currentTime
                onClick()
            }
        }
    }

    fun setOnClickListener(listener: () -> Unit) {}
}

// Использование
// button.setOnThrottledClickListener(500) {
//     // Обработка клика
//     // Нет накладных расходов на создание лямбды
// }

