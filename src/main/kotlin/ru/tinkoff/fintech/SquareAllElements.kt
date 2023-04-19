package ru.tinkoff.fintech

/**
 * Метод из задачи 1
 */
fun ArrayList<Int>.squareAllElements() {
    for (i in this.indices) this[i] *= this[i]
}