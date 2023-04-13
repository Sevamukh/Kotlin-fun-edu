package ru.tinkoff.fintech


class NumberToWords {

    private val units = mapOf(1 to "один", 2 to "два", 3 to "три", 4 to "четыре",
        5 to "пять", 6 to "шесть", 7 to "семь", 8 to "восемь", 9 to "девять")
    private val teens = mapOf(11 to "одиннадцать", 12 to "двенадцать", 13 to "тринадцать", 14 to "четырнадцать",
       15 to "пятнадцать", 16 to "шестнадцать", 17 to "семнадцать", 18 to "восемнадцать", 19 to "девятнадцать")
    private val tens = mapOf(1 to "десять", 2 to "двадцать", 3 to "тридцать", 4 to "сорок",
        5 to "пятьдесят", 6 to "шестьдесят", 7 to "семьдесят", 8 to "восемьдесят", 9 to "девяносто")
    private val hundreds = mapOf(1 to "сто", 2 to "двести", 3 to "триста", 4 to "четыреста",
        5 to "пятьсот", 6 to "шестьсот", 7 to "семьсот", 8 to "восемьсот", 9 to "девятьсот")

    fun convertNumberToWords(number: Int): String {
        val result: String
        val resultWords = ArrayList<String>()
        if (number < 1 || number > 1000) throw IllegalArgumentException("Данное число выходит за границы разрешенного диапазона")
        else {
            result = if (number == 1000) "Тысяча"
            else {
                val nHundreds = number / 100
                if (nHundreds > 0) resultWords.add(hundreds[nHundreds]!!)
                when (val n100 = number % 100) {
                    in 1..9 -> resultWords.add(units[n100]!!)
                    10 -> resultWords.add(tens[1]!!)
                    in 11..19 -> resultWords.add(teens[n100]!!)
                    else -> {
                        resultWords.add(tens[n100 / 10]!!)
                        if (n100 % 10 != 0) resultWords.add(units[n100 % 10]!!)
                    }
                }
                resultWords.joinToString(separator = " ")
            }
        }
        println(result)
        return result
    }
}


