package com.kirtar

import com.kirtar.system.FunctionSystem
import com.kirtar.util.CsvExporter
import kotlin.math.PI

/**
 * Точка входа в приложение.
 * Демонстрация экспорта в CSV для дальнейшего построения графиков.
 */
fun main() {
    // Пример: Выгрузим тригонометрическую часть (x <= 0) на отрезке [-π..0] с шагом 0.1
    CsvExporter.exportToCsv(
        fileName = "trig_part.csv",
        start = -PI,
        end = 0.0,
        step = 0.1,
        eps = 1e-7
    ) { x, eps -> FunctionSystem.compute(x, eps) }

    // Пример: Выгрузим логарифмическую часть (x > 0) на отрезке [0.1..5] с шагом 0.1
    CsvExporter.exportToCsv(
        fileName = "log_part.csv",
        start = 0.1,
        end = 5.0,
        step = 0.1,
        eps = 1e-7
    ) { x, eps -> FunctionSystem.compute(x, eps) }

    println("CSV files (trig_part.csv, log_part.csv) have been exported.")
}
