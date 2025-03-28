package com.kirtar.stubs

import kotlin.math.abs

/**
 * Заглушка для sin(x).
 * Возвращает заранее заготовленные значения из таблицы.
 */
object MySinStub {

    private val table = mapOf(
        0.0 to 0.0,
        (-Math.PI / 2) to -1.0,
        (Math.PI / 2) to 1.0,
        (Math.PI) to 0.0,
        (-Math.PI) to 0.0
    )

    fun sin(x: Double, eps: Double = 1e-7): Double {
        val closestKey = table.keys.minByOrNull { abs(it - x) } ?: 0.0
        return table[closestKey] ?: 0.0
    }
}
