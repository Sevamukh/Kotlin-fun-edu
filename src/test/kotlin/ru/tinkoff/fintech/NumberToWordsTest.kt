package ru.tinkoff.fintech

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import java.util.stream.Stream

class NumberToWordsTest {
    private val output = ByteArrayOutputStream()
    private val numberToWords = NumberToWords()

    companion object TestArgumentsProvider {
        @JvmStatic
        fun provideArgumentsForConvertNumberToWords(): Stream<Arguments> = Stream.of(
            Arguments.of(1, "один"),
            Arguments.of(11, "одиннадцать"),
            Arguments.of(20, "двадцать"),
            Arguments.of(21, "двадцать один"),
            Arguments.of(100, "сто"),
            Arguments.of(132, "сто тридцать два"),
            Arguments.of(1000, "тысяча"),
        )
    }

    @BeforeEach
    fun setUpStreams() {
        System.setOut(PrintStream(output))
    }

    @ParameterizedTest(name = "convertNumber should print \"{1}\" for Int = {0}")
    @MethodSource("provideArgumentsForConvertNumberToWords")
    fun convertNumberToWordsShouldPrintValidResult(num: Int, words: String) {
        numberToWords.convertNumberToWords(num)
        assertEquals(words, output.toString().trim(),
            "Неверный вывод")
    }
}