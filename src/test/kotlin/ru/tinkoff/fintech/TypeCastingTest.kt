package ru.tinkoff.fintech

import kotlin.test.Test
import kotlin.test.BeforeTest
import kotlin.test.assertEquals
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class TypeCastingTest {
    private val output = ByteArrayOutputStream()

    @BeforeTest
    fun setUpStreams() {
        System.setOut(PrintStream(output))
    }

    @Test
    fun typeCastIntPrintValidResult() {
        typeCast(2)
        assertEquals("Я получил Int = 2, его квадрат равен 4", output.toString().trim(),
            "Неверный вывод для целого числа")
    }

    @Test
    fun typeCastStringPrintValidResult() {
        typeCast("Привет, Андрей, ну где ты был, ну обними меня скорей!")
        assertEquals("Я получил тип String = 'Привет, Андрей, ну где ты был, ну обними меня скорей!', ее длина равна 53",
            output.toString().trim(),
            "Неверный вывод для целого числа")
    }

    @Test
    fun typeCastNullPrintValidResult() {
        typeCast(null)
        assertEquals("Я получил null", output.toString().trim(),
            "Неверный вывод для null")
    }
}