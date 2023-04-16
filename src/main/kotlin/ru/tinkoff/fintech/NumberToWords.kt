package ru.tinkoff.fintech


class NumberToWords {

    private val thousand = "Тысяча"
    private val units = mapOf(1 to "один", 2 to "два", 3 to "три", 4 to "четыре",
        5 to "пять", 6 to "шесть", 7 to "семь", 8 to "восемь", 9 to "девять")
    private val teens = mapOf(10 to "десять", 11 to "одиннадцать", 12 to "двенадцать", 13 to "тринадцать", 14 to "четырнадцать",
       15 to "пятнадцать", 16 to "шестнадцать", 17 to "семнадцать", 18 to "восемнадцать", 19 to "девятнадцать")
    private val tens = mapOf(2 to "двадцать", 3 to "тридцать", 4 to "сорок",
        5 to "пятьдесят", 6 to "шестьдесят", 7 to "семьдесят", 8 to "восемьдесят", 9 to "девяносто")
    private val hundreds = mapOf(1 to "сто", 2 to "двести", 3 to "триста", 4 to "четыреста",
        5 to "пятьсот", 6 to "шестьсот", 7 to "семьсот", 8 to "восемьсот", 9 to "девятьсот")

    fun convertNumberToWords(num: Int): String {
        val words = ArrayList<String>()
        if (num < 1 || num > 1000) throw IllegalArgumentException("Данное число выходит за границы разрешенного диапазона")
        return if (num == 1000) thousand
        else {
            val nHundreds = num / 100
            if (nHundreds > 0) words.add(hundreds.getValue(nHundreds))
            when (val nModulo100 = num % 100) {
                0 -> Unit
                in 1..9 -> words.add(units.getValue(nModulo100))
                in 10..19 -> words.add(teens.getValue(nModulo100))
                else -> {
                    words.add(tens.getValue(nModulo100 / 10))
                    if (nModulo100 % 10 != 0) words.add(units.getValue(nModulo100 % 10))
                }
            }
            words.joinToString(separator = " ")
        }
    }
}


