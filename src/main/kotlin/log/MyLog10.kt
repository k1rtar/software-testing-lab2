package com.kirtar.log

import com.kirtar.base.MyLn

/**
 * log10(x) = ln(x) / ln(10)
 */
object MyLog10 {
    fun log10(x: Double, eps: Double = 1e-7): Double {
        val lnX = MyLn.ln(x, eps)
        val ln10 = MyLn.ln(10.0, eps)
        return lnX / ln10
    }
}
