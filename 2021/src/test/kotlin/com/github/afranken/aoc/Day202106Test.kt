package com.github.afranken.aoc

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

internal class Day202106Test {

    private val AOC_EXAMPLE_INPUT = arrayOf("3","4","3","1","2")

    private val input: Array<String>
        get() {
            return getInput("com/github/afranken/aoc/Day202106-input.txt")[0].split(",").toTypedArray()
        }

    @Test
    fun testPart1Example() {
        val result = Day202106.part1(AOC_EXAMPLE_INPUT)
        Assertions.assertThat(result).isEqualTo(5934)
    }

    @Test
    fun testPart1Input() {
        val result = Day202106.part1(input)
        Assertions.assertThat(result).isEqualTo(351188)
    }

    @Test
    fun testPart2Example() {
        val result = Day202106.part2(AOC_EXAMPLE_INPUT)
        Assertions.assertThat(result).isEqualTo(26984457539)
    }

    @Test
    fun testPart2Input() {
        val result = Day202106.part2(input)
        Assertions.assertThat(result).isEqualTo(1595779846729)
    }
}
