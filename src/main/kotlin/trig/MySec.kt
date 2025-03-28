package com.kirtar.trig

import com.kirtar.base.MySin
import kotlin.math.abs
import kotlin.math.PI

/**
 * sec(x) = 1 / cos(x)
 * cos(x) можно получить как sin(x + π/2),
 * но нужно убедиться, что sin(x+π/2) != 0.
 */
object MySec {
    fun sec(x: Double, eps: Double = 1e-7): Double {
        val shifted = x + PI / 2
        val sinShift = MySin.sin(shifted, eps)
        require(abs(sinShift) > 1e-15) { "sec(x) is undefined because cos(x) ~ 0" }
        return 1.0 / sinShift
    }
}
