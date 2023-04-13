package ru.tinkoff.fintech

import java.time.LocalDate

fun typeCast(obj : Any?) : String? {
    return when (obj) {
        null -> null
        is String -> "Я получил тип String = $obj, ее длина равна ${obj.length}"
        is Int -> "Я получил Int = $obj, его квадрат равен ${obj*obj}"
        is Double -> "Я получил Double = $obj, это число округляется до ${String.format("%.2f", obj)}"
        is LocalDate -> {
            "Я получил LocalDate = $obj, она ${if (obj < 
                LocalDate.of(2006, 12,24)) "" else "не "}меньше даты основания Tinkoff"
        }
        else -> "Мне этот тип неизвестен"
    }
}