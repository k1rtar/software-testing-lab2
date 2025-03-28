package com.kirtar.stubs

import kotlin.math.abs

/**
 * Заглушка для ln(x).
 * Возвращает приблизительные значения из заранее заготовленной таблицы.
 */
object MyLnStub {

    private val table = mapOf(
        1.0 to 0.0,
        2.0 to 0.693147,
        3.0 to 1.098612,
        10.0 to 2.302585
    )

    fun ln(x: Double, eps: Double = 1e-7): Double {
        // Ищем ближайшее x в таблице
        val closestKey = table.keys.minByOrNull { abs(it - x) } ?: 1.0
        return table[closestKey] ?: Double.NaN
    }
}
