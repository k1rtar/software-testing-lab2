package com.kirtar.system

import com.kirtar.base.MySin
import com.kirtar.trig.MyCsc
import com.kirtar.trig.MySec
import com.kirtar.trig.MyTan
import com.kirtar.trig.MyCot
import com.kirtar.log.MyLog2
import com.kirtar.log.MyLog3
import com.kirtar.log.MyLog5
import com.kirtar.log.MyLog10
import com.kirtar.base.MyLn
import kotlin.math.pow

/**
 * Система функций (piecewise):
 *  x <= 0:
 *    ((((((sin(x) / csc(x)) - sec(x)) ^ 2) / tan(x)) / csc(x))
 *     - (((((csc(x) ^ 3) / sec(x)) / sec(x))
 *        + (csc(x) + ((sin(x) + tan(x)) - csc(x))))
 *        + (cot(x) - tan(x))))
 *
 *  x > 0:
 *    (((((log_3(x)^3) * ln(x))
 *       - (log_2(x) * (log_2(x)/log_3(x))))
 *       / log_5(x))
 *     - (ln(x) - ((log_10(x)*log_10(x)) / ln(x))))
 */
object FunctionSystem {

    fun compute(x: Double, eps: Double = 1e-7): Double {
        return if (x <= 0) {
            computeTrigPart(x, eps)
        } else {
            computeLogPart(x, eps)
        }
    }

    private fun computeTrigPart(x: Double, eps: Double): Double {
        val sinVal = MySin.sin(x, eps)
        val cscVal = MyCsc.csc(x, eps)
        val secVal = MySec.sec(x, eps)
        val tanVal = MyTan.tan(x, eps)
        val cotVal = MyCot.cot(x, eps)

        // part1 = ((((sin(x)/csc(x)) - sec(x))^2) / tan(x)) / csc(x)
        val numerator = (sinVal / cscVal) - secVal
        val part1 = ((numerator * numerator) / tanVal) / cscVal

        // part2 = ((((csc(x)^3)/sec(x))/sec(x))
        //         + (csc(x) + ((sin(x)+tan(x)) - csc(x)))
        //         + (cot(x) - tan(x)))
        val csc3 = cscVal * cscVal * cscVal
        val part2a = ((csc3 / secVal) / secVal)
        val part2b = cscVal + ((sinVal + tanVal) - cscVal)
        val part2c = (cotVal - tanVal)
        val part2 = part2a + part2b + part2c

        return part1 - part2
    }

    private fun computeLogPart(x: Double, eps: Double): Double {
        val lnVal = MyLn.ln(x, eps)
        val log2Val = MyLog2.log2(x, eps)
        val log3Val = MyLog3.log3(x, eps)
        val log5Val = MyLog5.log5(x, eps)
        val log10Val = MyLog10.log10(x, eps)

        // part1 = ((((log3(x)^3)*ln(x)) - (log2(x)*(log2(x)/log3(x)))) / log5(x))
        val part1Num = (log3Val.pow(3.0) * lnVal) -
                (log2Val * (log2Val / log3Val))
        val part1 = part1Num / log5Val

        // part2 = (ln(x) - ((log10(x)*log10(x))/ln(x)))
        val part2 = lnVal - ((log10Val * log10Val) / lnVal)

        return part1 - part2
    }
}
