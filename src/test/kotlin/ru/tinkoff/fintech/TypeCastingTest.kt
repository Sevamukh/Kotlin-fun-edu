package ru.tinkoff.fintech

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import java.time.LocalDate
import java.util.logging.Handler
import java.util.stream.Stream

class TypeCastingTest {
    private val output = ByteArrayOutputStream()

    @BeforeEach
    fun setUpStreams() {
        System.setOut(PrintStream(output))
    }

    @Test
    fun typeCast_Int_ShouldPrintValidResult() {
        typeCast(2)
        assertEquals("Я получил Int = 2, его квадрат равен 4", output.toString().trim(),
            "Неверный вывод для целого числа")
    }

    @ParameterizedTest(name = "Used Double = {0}, expected full and short String: {1} {2}")
    @MethodSource("provideArgumentsForTypeCastDouble")
    fun typeCast_Double_ShouldPrintValidResult(num: Double, numStr: String, shortNumStr: String) {
        typeCast(num)
        assertEquals("Я получил Double = $numStr, это число округляется до $shortNumStr",
            output.toString().trim(),
            "Неверный вывод для вещественного числа")
    }

    @Test
    fun typeCast_String_ShouldPrintValidResult() {
        typeCast("Привет, Андрей, ну где ты был, ну обними меня скорей!")
        assertEquals("Я получил тип String = 'Привет, Андрей, ну где ты был, ну обними меня скорей!', ее длина равна 53",
            output.toString().trim(),
            "Неверный вывод для строки")
    }

    @ParameterizedTest(name = "Used LocalDate = {0}")
    @MethodSource("provideArgumentsForTypeCastLocalDate")
    fun typeCast_LocalDate_ShouldPrintValidResult(date: LocalDate, expectedStr: String) {
        typeCast(date)
        assertEquals(expectedStr, output.toString().trim(), "Неверный вывод для даты")
    }

    @Test
    fun typeCast_Null_ShouldPrintValidResult() {
        typeCast(null)
        assertEquals("Я получил null", output.toString().trim(),
            "Неверный вывод для null")
    }

    @Test
    fun typeCast_UnknownType_ShouldPrintValidResult() {
        typeCast(Handler::class)
        assertEquals("Мне этот тип неизвестен", output.toString().trim(),
            "Неверный вывод для нестандартного типа")
    }

    companion object {
        @JvmStatic
        fun provideArgumentsForTypeCastDouble(): Stream<Arguments> = Stream.of(
            Arguments.of(1.0, "1.0", "1"),
            Arguments.of(0.001, "0.001", "0"),
            Arguments.of(1.005, "1.005", "1.01"),
            Arguments.of(-1.005, "-1.005", "-1.01"),
        )

        @JvmStatic
        fun provideArgumentsForTypeCastLocalDate(): Stream<Arguments> = Stream.of(
            Arguments.of(LocalDate.of(1990,1,1),
                "Я получил LocalDate = 1990-01-01, она меньше даты основания Tinkoff"),
            Arguments.of(LocalDate.of(2023,4,21),
                "Я получил LocalDate = 2023-04-21, она не меньше даты основания Tinkoff"),
        )
    }
}