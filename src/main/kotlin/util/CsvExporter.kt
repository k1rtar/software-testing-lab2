package com.kirtar.util

import java.io.File

/**
 * Утилита для экспорта (x, f(x)) в CSV-файл.
 */
object CsvExporter {
    /**
     * @param fileName имя выходного файла
     * @param start    начальное значение x
     * @param end      конечное значение x
     * @param step     шаг изменения x
     * @param eps      точность вычисления
     * @param function функция (x, eps) -> Double
     */
    fun exportToCsv(
        fileName: String,
        start: Double,
        end: Double,
        step: Double,
        eps: Double,
        function: (Double, Double) -> Double
    ) {
        val file = File(fileName)
        file.printWriter().use { out ->
            out.println("x;f(x)")
            var xVar = start
            val increasing = step > 0

            while (true) {
                if (increasing && xVar > end) break
                if (!increasing && xVar < end) break

                val value = try {
                    function(xVar, eps)
                } catch (e: Exception) {
                    Double.NaN
                }
                out.println("$xVar;$value")
                xVar += step
            }
        }
    }
}
