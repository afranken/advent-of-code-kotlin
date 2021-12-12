package com.github.afranken.aoc

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

internal class Day202107Test {

    private val AOC_EXAMPLE_INPUT = arrayOf(16, 1, 2, 0, 4, 2, 7, 1, 2, 14)

    private val input: Array<Int>
        get() {
            return getInput("com/github/afranken/aoc/Day202107-input.txt")[0].split(",")
                .map { Integer.valueOf(it) }.toTypedArray()
        }

    @Test
    fun testPart1Example() {
        val result = Day202107.part1(AOC_EXAMPLE_INPUT)
        Assertions.assertThat(result).isEqualTo(37)
    }

    @Test
    fun testPart1Input() {
        val result = Day202107.part1(input)
        Assertions.assertThat(result).isEqualTo(336120)
    }

    @Test
    fun testPart2Example() {
        val result = Day202107.part2(AOC_EXAMPLE_INPUT)
        Assertions.assertThat(result).isEqualTo(168)
    }

    @Test
    fun testPart2Input() {
        val result = Day202107.part2(input)
        Assertions.assertThat(result).isEqualTo(96864235)
    }
}
