package com.kirtar.log

import com.kirtar.base.MyLn

/**
 * log5(x) = ln(x) / ln(5)
 */
object MyLog5 {
    fun log5(x: Double, eps: Double = 1e-7): Double {
        val lnX = MyLn.ln(x, eps)
        val ln5 = MyLn.ln(5.0, eps)
        return lnX / ln5
    }
}
