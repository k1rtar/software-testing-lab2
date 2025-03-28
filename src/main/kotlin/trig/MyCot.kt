package com.kirtar.trig

import com.kirtar.base.MySin
import kotlin.math.abs
import kotlin.math.PI

/**
 * cot(x) = cos(x) / sin(x) = tan(x) ^ -1
 * но для "cos(x)" используем sin(x+π/2).
 */
object MyCot {
    fun cot(x: Double, eps: Double = 1e-7): Double {
        val sinVal = MySin.sin(x, eps)
        val cosVal = MySin.sin(x + PI / 2, eps)
        require(abs(sinVal) > 1e-15) { "cot(x) undefined because sin(x) ~ 0" }
        return cosVal / sinVal
    }
}
