package ru.tinkoff.fintech

fun strangeFunction(list: List<Double?>): Double? {
    return if (list.all { it == null }) null
    else list.asSequence()
        .filterNotNull()
        .map { if (it.toInt() % 2 == 0) it / 2 else it * it }
        .filter { it <= 25 }
        .sortedDescending()
        .take(10)
        .sum()
}