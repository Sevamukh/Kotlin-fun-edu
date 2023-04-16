package ru.tinkoff.fintech

fun ArrayList<Int>.squareAllElements() {
    for (i in this.indices) this[i] *= this[i]
}