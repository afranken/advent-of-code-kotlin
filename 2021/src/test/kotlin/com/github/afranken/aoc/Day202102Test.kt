package com.github.afranken.aoc

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day202102Test {
    private val AOC_EXAMPLE_INPUT = arrayOf("forward 5",
            "down 5",
            "forward 8",
            "up 3",
            "down 8",
            "forward 2")
    private val input: Array<String> get() {return getInput("com/github/afranken/aoc/Day202102-input.txt")}

    @Test
    fun testPart1Example() {
        val result = Day202102.part1(AOC_EXAMPLE_INPUT)
        assertThat(result).isEqualTo(150)
    }

    @Test
    fun testPart1Input() {
        val result = Day202102.part1(input)
        assertThat(result).isEqualTo(2147104)
    }

    @Test
    fun testPart2Example() {
        val result = Day202102.part2(AOC_EXAMPLE_INPUT)
        assertThat(result).isEqualTo(900)
    }

    @Test
    fun testPart2Input() {
        val result = Day202102.part2(input)
        assertThat(result).isEqualTo(2044620088)
    }
}
