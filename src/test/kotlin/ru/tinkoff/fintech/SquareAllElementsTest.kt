package ru.tinkoff.fintech

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import io.qameta.allure.junit5.AllureJunit5
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(AllureJunit5::class)
class SquareAllElementsTest {

    @Test
    fun squareAllElementsShouldReturnValidResult() {
        val actualList = arrayListOf(-1, 0, 2)
        actualList.squareAllElements()
        assertEquals(arrayListOf(1, 0, 4), actualList,
            "Допущена ошибка при возведении элементов коллекции в квадрат")
    }
}