package ru.tinkoff.fintech

import java.time.LocalDate
import java.util.Locale.ENGLISH

/**
 * Метод из задачи 2
 */
fun typeCast(obj: Any?): String {
    val result = when (obj) {
        null -> "Я получил null"
        is String -> "Я получил тип String = '$obj', ее длина равна ${obj.length}"
        is Int -> "Я получил Int = $obj, его квадрат равен ${obj * obj}"
        is Double -> "Я получил Double = $obj, это число округляется до ${
            String.format(ENGLISH, "%.2f", obj).trimEnd('0').trimEnd('.')}"
        is LocalDate -> "Я получил LocalDate = $obj, она ${
            if (obj < LocalDate.of(2006, 12,24)) "" else "не "
        }меньше даты основания Tinkoff"
        else -> "Мне этот тип неизвестен"
    }
    println(result)
    return result
}