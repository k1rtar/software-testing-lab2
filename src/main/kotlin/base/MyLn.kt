package com.kirtar.base

import kotlin.math.abs
import kotlin.math.exp

/**
 * Базовая логарифмическая функция ln(x),
 * реализованная через метод Ньютона.
 * x > 0
 */
object MyLn {
    fun ln(x: Double, eps: Double = 1e-7): Double {
        require(x > 0) { "ln(x) is undefined for x <= 0" }

        // Ищем y: e^y = x => y = ln(x)
        var y = if (x > 1) x / 2.0 else 1.0
        while (true) {
            val eY = exp(y)
            val diff = eY - x
            if (abs(diff) < eps) break
            y -= diff / eY
        }
        return y
    }
}
