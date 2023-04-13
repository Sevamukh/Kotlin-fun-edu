package ru.tinkoff.fintech

import kotlin.math.max
import kotlin.math.roundToInt

fun strangeFunction(arg : List<Double?>) : Double? {
    val result =  if (arg.all{it == null}) null
    else {
        val value = arg.filterNotNull()
            .map {if (it.toInt() % 2 == 0) it / 2 else it * it}
            .filter{it <= 25}
        (value.sortedDescending()
            .dropLast(max(0, value.size - 10))
            .sum() * 100)
            .roundToInt() / 100.0
    }
    if (result != null) println(result)
    return result
}