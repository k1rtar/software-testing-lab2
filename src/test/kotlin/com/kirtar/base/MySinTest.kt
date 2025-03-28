package com.kirtar.base

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import kotlin.math.abs

class MySinTest {

    @ParameterizedTest
    @CsvSource(
        "0.0, 0.0",
        "1.57079632679, 1.0",    // ~ π/2
        "-1.57079632679, -1.0", // ~ -π/2
        "3.14159265359, 0.0"    // ~ π
    )
    fun testKnownPoints(x: Double, expected: Double) {
        val actual = MySin.sin(x, 1e-7)
        assertTrue(abs(actual - expected) < 1e-5, "sin($x) should be close to $expected")
    }

    @Test
    fun testSmallValue() {
        val x = 0.00001
        val expected = x // sin(x) ~ x при малых x
        val actual = MySin.sin(x, 1e-9)
        assertTrue(abs(actual - expected) < 1e-9)
    }
}
