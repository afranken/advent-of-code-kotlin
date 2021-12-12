package com.github.afranken.aoc

import kotlin.math.abs

object Day202107 {

    fun part1(inputs: Array<Int>): Int {
        val min = inputs.minOrNull()!!
        val max = inputs.maxOrNull()!!

        val fuelList = (min..max).map { line ->
            inputs.sumOf { crab ->
                abs(line - crab)
            }
        }

        return fuelList.minOrNull()!!
    }

    fun part2(inputs: Array<Int>): Int {
        val min = inputs.minOrNull()!!
        val max = inputs.maxOrNull()!!

        val fuelList = (min..max).map { line ->
            inputs.sumOf { crab ->
                val diff = abs(line - crab)
                diff * (1 + diff) / 2
            }
        }

        return fuelList.minOrNull()!!
    }
}
