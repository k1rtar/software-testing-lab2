package com.kirtar

import com.kirtar.stubs.MySinStub
import com.kirtar.base.MyLn
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * Пример, как можно подменить sin(x) заглушкой при интеграционных тестах.
 * В реальном коде вы бы подменяли вызовы внутри "FunctionSystem",
 * используя подход Dependency Injection или мок-фреймворки.
 */
class IntegrationWithStubsTest {

    @Test
    fun testSinStubAtSpecificPoint() {
        // Демонстрация: хотим проверить, что sinStub(-π/2) даёт -1.0
        val x = -Math.PI / 2
        val stubVal = MySinStub.sin(x, 1e-7)
        assertEquals(-1.0, stubVal, 1e-9)
    }

    @Test
    fun testCombineStubAndRealLn() {
        // Условный пример "интеграции":
        // sin(x) -> Stub, ln(x) -> реальная
        // Просто иллюстрация (никаких реальных расчётов системы).
        val x = 2.0
        val sinStubVal = MySinStub.sin(x, 1e-7)
        val lnRealVal = MyLn.ln(x, 1e-7)
        println("sinStub(2.0) = $sinStubVal, ln(2.0) = $lnRealVal")

        // Проверяем, что не NaN
        assertFalse(sinStubVal.isNaN())
        assertFalse(lnRealVal.isNaN())
    }
}
