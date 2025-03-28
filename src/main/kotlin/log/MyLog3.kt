package com.kirtar.log

import com.kirtar.base.MyLn

/**
 * log3(x) = ln(x) / ln(3)
 */
object MyLog3 {
    fun log3(x: Double, eps: Double = 1e-7): Double {
        val lnX = MyLn.ln(x, eps)
        val ln3 = MyLn.ln(3.0, eps)
        return lnX / ln3
    }
}
