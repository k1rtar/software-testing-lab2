package com.kirtar.trig

import com.kirtar.base.MySin
import kotlin.math.abs

/**
 * csc(x) = 1 / sin(x)
 */
object MyCsc {
    fun csc(x: Double, eps: Double = 1e-7): Double {
        val sinVal = MySin.sin(x, eps)
        require(abs(sinVal) > 1e-15) { "csc(x) is undefined because sin(x) ~ 0" }
        return 1.0 / sinVal
    }
}
