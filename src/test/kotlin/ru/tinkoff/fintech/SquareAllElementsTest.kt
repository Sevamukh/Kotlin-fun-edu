package ru.tinkoff.fintech

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*


class SquareAllElementsTest {

    @Test
    fun squareAllElementsReturnsValidResult() {
        val actualArrayList = arrayListOf(-1, 0, 2)
        actualArrayList.squareAllElements()
        assertEquals(arrayListOf(1, 0, 4), actualArrayList, "bfgb")
    }
}