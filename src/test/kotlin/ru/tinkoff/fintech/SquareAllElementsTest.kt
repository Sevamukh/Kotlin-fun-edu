package ru.tinkoff.fintech

import kotlin.test.Test
import kotlin.test.assertEquals


class SquareAllElementsTest {

    @Test
    fun squareAllElementsReturnsValidResult() {
        val actualList = arrayListOf(-1, 0, 2)
        actualList.squareAllElements()
        assertEquals(arrayListOf(1, 0, 4), actualList,
            "Допущена ошибка при возведении элементов коллекции в квадрат")
    }
}