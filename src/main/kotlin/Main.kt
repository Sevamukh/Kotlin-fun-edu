import ru.tinkoff.fintech.NumberToWords
import ru.tinkoff.fintech.squareAllElements
import ru.tinkoff.fintech.strangeFunction
import ru.tinkoff.fintech.typeCast
import kotlin.math.roundToInt

fun main() {
    // Задача 1
    val list1 = arrayListOf(-1, 0, 2)
    list1.squareAllElements()
    println(list1)

    // Задача 2
    println(typeCast("Privet"))

    // Задача 3
    println((strangeFunction(listOf(13.31, 3.98, 12.0, 2.99, 9.0))!! * 100).roundToInt() / 100.0)

    // Задача 4
    val numberToWords = NumberToWords()
    println(numberToWords.convertNumberToWords(100))
}
