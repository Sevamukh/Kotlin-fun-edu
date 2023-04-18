package ru.tinkoff.fintech

import kotlin.math.roundToInt

fun strangeFunction(list: List<Double?>): Double {
    val result = list.asSequence()
        .filterNotNull()
        .map { if (it.toInt() % 2 == 0) it * it else it / 2 }
        .filter { it <= 25 }
        .sortedDescending()
        .take(10)
        .sum()
    println((result * 100).roundToInt() / 100.0)
    return result
}