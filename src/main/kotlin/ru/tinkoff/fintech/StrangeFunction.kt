package ru.tinkoff.fintech

import java.util.Locale.ENGLISH

/**
 * Метод из задачи 3
 */
fun strangeFunction(list: List<Double?>): Double {
    return list.asSequence()
        .filterNotNull()
        .map { if (it.toInt() % 2 == 0) it * it else it / 2 }
        .filter { it <= 25 }
        .sortedDescending()
        .take(10)
        .sum()
        .apply { println(String.format(ENGLISH, "%.2f", this).trimEnd('0').trimEnd('.')) }
}