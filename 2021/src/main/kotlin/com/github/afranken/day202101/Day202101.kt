package com.github.afranken.day202101

/**
 * This implements the answer to Day 2021/12/01
 * https://adventofcode.com/2021/day/1
 */
object Day202101 {
    /**
     * Implements Part1 of the Day1 puzzle.
     */
    fun computePart1(inputs: Array<Int>): Int {
        var increases = 0
        var lastnumber = -1
        for (i in inputs.indices) {
            val input = inputs[i]
            if (lastnumber != -1 && input > lastnumber) {
                increases++
            }
            lastnumber = input
        }
        return increases
    }

    fun computePart2(inputs: Array<Int>): Int {
        var increases = 0
        var lastnumber = -1
        for (i in 2 until inputs.size) {
            val window1 = inputs[i - 2]
            val window2 = inputs[i - 1]
            val window3 = inputs[i]
            val input = window1 + window2 + window3
            if (lastnumber != -1 && input > lastnumber) {
                increases++
            }
            lastnumber = input
        }
        return increases
    }
}
