package com.kirtar.base

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import kotlin.math.abs

class MyLnTest {

    @ParameterizedTest
    @CsvSource(
        "1.0, 0.0",
        "2.0, 0.693147",
        "3.0, 1.098612",
        "10.0, 2.302585"
    )
    fun testKnownPoints(x: Double, expected: Double) {
        val actual = MyLn.ln(x, 1e-7)
        assertTrue(abs(actual - expected) < 1e-5, "ln($x) should be close to $expected")
    }

    @Test
    fun testDomainError() {
        assertThrows(IllegalArgumentException::class.java) {
            MyLn.ln(-1.0, 1e-7)
        }
    }
}
