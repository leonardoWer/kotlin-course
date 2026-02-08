## 📚 Теория: inline, noinline, crossinline
### 1. inline — что это и зачем?
```kotlin
// Без inline (обычная функция высшего порядка)
fun withoutInline(block: () -> Unit) {
    println("Начало")
    block()
    println("Конец")
}

// С inline
inline fun withInline(block: () -> Unit) {
    println("Начало")
    block()
    println("Конец")
}

fun main() {
    // -> Без inline
    // под капотом после компиляции:
    // 1. Создается анонимный класс для лямбды
    // 2. Вызов функции
    withoutInline { println("Выполняю блок") }

    // -> С inline 
    // под капотом после компиляции:
    // println("Начало")
    // println("Выполняю блок") 
    // println("Конец")
    withInline { println("Выполняю блок") }
}
```

#### Преимущества inline:
- Нет накладных расходов на вызов функции
- Нет создания объектов для лямбд
- Можно использовать reified generics

#### Недостатки:
- Увеличение размера байт-кода
- Не подходит для больших функций

### 2. reified — типы во время выполнения:
```kotlin
// Без reified (не скомпилируется!)
// fun <T> checkType(obj: Any): Boolean = obj is T

// С reified
inline fun <reified T> checkType(obj: Any): Boolean = obj is T

inline fun <reified T> castOrNull(obj: Any): T? = obj as? T

inline fun <reified T> createActivity(context: Context) {
    val intent = Intent(context, T::class.java)
    context.startActivity(intent)
}

fun main() {
    val str = "Hello"

    println(checkType<String>(str)) // true
    println(checkType<Int>(str))    // false
    
    val number: Int? = castOrNull("123") // null
    println(number)
    
    // Практический пример в Android:
    // startActivity<MainActivity>(context)
}
```

### 3. noinline — когда не нужно инлайнить:
```kotlin
// block1 будет инлайниться, block2 — нет
inline fun process(
   noinline block1: () -> Unit,
   block2: () -> Unit,
   crossinline block3: () -> Unit
) {
   println("Начало")

   // block1 можно передать в другую функцию
   executeLater(block1)

   // block2 инлайнится здесь
   block2()

   // block3 нельзя использовать с нелокальным return
   runOnUiThread { block3() }

   println("Конец")
}

fun executeLater(block: () -> Unit) {
// Храним лямбду для выполнения позже
}

fun runOnUiThread(block: () -> Unit) {
// Выполняем на UI потоке
}

fun main() {
    process(
        block1 = { println("Блок 1") },
        block2 = {
            println("Блок 2")
            return // нелокальный return - выйдет из main!
        },
        block3 = {
            println("Блок 3")
            // return здесь вызовет ошибку компиляции из-за crossinline
        }
    )
}
```

### 4. crossinline — запрет нелокального return:
```kotlin
inline fun runSafe(crossinline block: () -> Unit) {
   try {
       println("Начало безопасного выполнения")
       block()
   } catch (e: Exception) {
       println("Ошибка: ${e.message}")
   } finally {
    println("Завершение")
   }
}

fun main() {
    runSafe {
        println("Выполняю операцию")
        // return // Ошибка компиляции: нельзя использовать нелокальный return!
        // Но можно использовать локальный return
        if (true) {
            return@runSafe // локальный return - выйдет только из лямбды
        }
        println("Это не выполнится")
    }
    println("Программа продолжает работу")
}
```