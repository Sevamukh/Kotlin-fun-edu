package ru.tinkoff.fintech

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SquareAllElementsTest {

    @Test
    fun squareAllElementsShouldReturnValidResult() {
        val actualList = arrayListOf(-1, 0, 2)
        actualList.squareAllElements()
        assertEquals(arrayListOf(1, 0, 4), actualList,
            "Допущена ошибка при возведении элементов коллекции в квадрат")
    }
}