package com.github.afranken.aoc

/**
 * This implements the answer to Day 2020/12/01
 * https://adventofcode.com/2020/day/1
 */
object Day202001 {
    var NOT_FOUND = -1

    /**
     * Implements Part1 of the Day1 puzzle.
     * This is an optimized twoSum with only one pass-through of the incoming Array/List, making
     * this a O(N) runtime while trading for memory
     */
    fun part1(inputs: Array<Int>, target: Int): Int {
        val lookupTable = HashMap<Int, Int>()
        for (i in inputs.indices) {
            val input = inputs[i]
            val index = lookupTable[target - input]
            if (index != null) {
                return input * inputs[index]
            }
            lookupTable[input] = i
        }
        return NOT_FOUND
    }
}
