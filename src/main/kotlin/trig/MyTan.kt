package com.kirtar.trig

import com.kirtar.base.MySin
import kotlin.math.abs
import kotlin.math.PI

/**
 * tan(x) = sin(x) / cos(x).
 * cos(x) = sin(x + π/2).
 */
object MyTan {
    fun tan(x: Double, eps: Double = 1e-7): Double {
        val sinVal = MySin.sin(x, eps)
        val cosVal = MySin.sin(x + PI / 2, eps)
        require(abs(cosVal) > 1e-15) { "tan(x) undefined because cos(x) ~ 0" }
        return sinVal / cosVal
    }
}
