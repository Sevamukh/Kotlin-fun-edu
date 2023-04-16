package ru.tinkoff.fintech

import kotlin.test.Test
import kotlin.test.assertEquals


class SquareAllElementsTest {

    @Test
    fun squareAllElementsReturnsValidResult() {
        val actualArrayList = arrayListOf(-1, 0, 2)
        actualArrayList.squareAllElements()
        assertEquals(arrayListOf(1, 0, 4), actualArrayList, "Сообщение")
    }
}