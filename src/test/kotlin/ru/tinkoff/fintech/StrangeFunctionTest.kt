package ru.tinkoff.fintech

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import java.util.stream.Stream

class StrangeFunctionTest {
    private val output = ByteArrayOutputStream()

    @BeforeEach
    fun setUpStreams() {
        System.setOut(PrintStream(output))
    }

    @ParameterizedTest(name = "strangeFunction should return valid result for List = {0}")
    @MethodSource("provideArgumentsForStrangeFunction")
    fun strangeFunctionShouldPrintAndReturnValidResult(list: List<Double?>, total: Double, totalStr: String) {
        val returnedTotal = strangeFunction(list)
        val printedTotal = output.toString().trim()
        assertAll(
             { assertEquals(total, returnedTotal, 0.01, "Вернулось неверное число") },
             { assertEquals(totalStr, printedTotal, "Выведено неверное число") },
        )
    }

    companion object {
        @JvmStatic
        fun provideArgumentsForStrangeFunction(): Stream<Arguments> = Stream.of(
            Arguments.of(listOf<Double>(), 0, "0"),
            Arguments.of(listOf(1), 0.5, "0.5"),
            Arguments.of(listOf(1.01), 0.505, "0.51"),
            Arguments.of(listOf(2, null), 4, "4"),
            Arguments.of(listOf(4, 6), 16, "16"),
            Arguments.of(listOf(13.31, 3.98, 12.0, 2.99, 9.0), 22.09, "22.09"),
            Arguments.of(listOf(2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 4), 52, "52"),
        )
    }
}