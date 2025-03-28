package com.kirtar.system

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class FunctionSystemTest {

    /**
     * Проверяем ветку x <= 0 (тригонометрическая часть).
     * Здесь можно сравнить с "эталоном", если вы заранее вычислили
     * через WolframAlpha или любую другую точную систему.
     */
    @ParameterizedTest
    @CsvSource(
        "-0.1, -0.1",
        "-1.0, -1.0",
        "-3.14159265, -3.14"
    )
    fun testTrigPart(x: Double, dummy: Double) {
        val result = FunctionSystem.compute(x, 1e-7)
        println("x=$x => trig-part => $result")
        assertFalse(result.isNaN())
    }

    /**
     * Проверяем ветку x > 0 (логарифмическая часть).
     */
    @ParameterizedTest
    @CsvSource(
        "0.1, 0.1",
        "1.0, 1.0",
        "2.0, 2.0",
        "5.0, 5.0"
    )
    fun testLogPart(x: Double, dummy: Double) {
        val result = FunctionSystem.compute(x, 1e-7)
        println("x=$x => log-part => $result")
        // При x=1 есть деление на log5(1)=0, потенциальный разрыв. Может быть исключение.
        // В реальном коде можно обрабатывать.
    }
}
