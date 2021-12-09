package com.github.afranken.aoc

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

internal class Day202105Test {

    private val AOC_EXAMPLE_INPUT = arrayOf(
        "0,9 -> 5,9",
        "8,0 -> 0,8",
        "9,4 -> 3,4",
        "2,2 -> 2,1",
        "7,0 -> 7,4",
        "6,4 -> 2,0",
        "0,9 -> 2,9",
        "3,4 -> 1,4",
        "0,0 -> 8,8",
        "5,5 -> 8,2"
    )

    private val input: Array<String>
        get() {
            return getInput("com/github/afranken/aoc/Day202105-input.txt")
        }

    @Test
    fun testPart1Example() {
        val result = Day202105.part1(AOC_EXAMPLE_INPUT)
        Assertions.assertThat(result).isEqualTo(5)
    }

    @Test
    fun testPart1Input() {
        val result = Day202105.part1(input)
        Assertions.assertThat(result).isEqualTo(6225)
    }

    @Test
    fun testPart2Example() {
        val result = Day202105.part2(AOC_EXAMPLE_INPUT)
        Assertions.assertThat(result).isEqualTo(12)
    }

    @Test
    fun testPart2Input() {
        val result = Day202105.part2(input)
        Assertions.assertThat(result).isEqualTo(22116)
    }

}
