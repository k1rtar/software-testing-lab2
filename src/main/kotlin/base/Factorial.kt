package com.kirtar.base

/**
 * Простейший объект для вычисления факториала.
 * Можно кэшировать, но здесь оставим простой вариант.
 */
object Factorial {
    fun factorial(n: Int): Double {
        require(n >= 0) { "Factorial is undefined for negative n" }
        var result = 1.0
        for (i in 1..n) {
            result *= i
        }
        return result
    }
}
