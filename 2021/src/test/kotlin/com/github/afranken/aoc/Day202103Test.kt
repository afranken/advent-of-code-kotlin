package com.github.afranken.aoc

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.io.IOException
import java.net.URISyntaxException

internal class Day202103Test {
    private val AOC_EXAMPLE_INPUT = arrayOf("00100", "11110", "10110", "10111", "10101", "01111", "00111", "11100", "10000", "11001", "00010", "01010")
    private val input: Array<String> get() {return Util.getInput("com/github/afranken/aoc/Day202103-input.txt")}

    @Test
    fun testPart1Example() {
        val result = Day202103.part1(AOC_EXAMPLE_INPUT)
        assertThat(result).isEqualTo(198)
    }

    @Test
    fun testPart1Input() {
        val result = Day202103.part1(input)
        assertThat(result).isEqualTo(1082324)
    }

    @Test
    fun testPart2Example() {
        val result = Day202103.part2(AOC_EXAMPLE_INPUT)
        assertThat(result).isEqualTo(230)
    }

    @Test
    fun testPart2Input() {
        val result = Day202103.part2(input)
        assertThat(result).isEqualTo(1353024)
    }
}
