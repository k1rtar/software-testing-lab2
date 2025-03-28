package com.kirtar.base

import kotlin.math.abs
import kotlin.math.pow

/**
 * Базовая тригонометрическая функция sin(x),
 * реализованная через ряд Тейлора (Maclaurin) с точностью eps.
 */
object MySin {

    fun sin(x: Double, eps: Double = 1e-7): Double {
        var term = x
        var sum = 0.0
        var n = 1
        var sign = 1.0

        while (abs(term) > eps) {
            sum += term
            n += 2
            sign = -sign
            term = sign * x.pow(n) / Factorial.factorial(n)
        }
        return sum
    }
}
