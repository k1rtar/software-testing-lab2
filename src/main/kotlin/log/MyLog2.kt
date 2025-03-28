package com.kirtar.log

import com.kirtar.base.MyLn

/**
 * log2(x) = ln(x) / ln(2)
 */
object MyLog2 {
    fun log2(x: Double, eps: Double = 1e-7): Double {
        val lnX = MyLn.ln(x, eps)
        val ln2 = MyLn.ln(2.0, eps)
        return lnX / ln2
    }
}
