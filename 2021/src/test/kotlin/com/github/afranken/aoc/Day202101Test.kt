package com.github.afranken.aoc

import com.github.afranken.aoc.Day202101.part1
import com.github.afranken.aoc.Day202101.part2
import org.assertj.core.api.Assertions.assertThat
import java.io.File
import java.io.IOException
import java.net.URISyntaxException
import kotlin.test.Test

object Day202101Test {
    private val AOC_EXAMPLE_INPUT = arrayOf(199, 200, 208, 210, 200, 207, 240, 269, 260, 263)

    @Test
    fun testPart1Example() {
        val result = part1(AOC_EXAMPLE_INPUT)
        assertThat(result).isEqualTo(7)
    }

    @Test
    @Throws(URISyntaxException::class, IOException::class)
    fun testPart1Input() {
        val result = part1(input)
        assertThat(result).isEqualTo(1298) // correct result.
    }

    @Test
    fun testPart2Example() {
        val result = part2(AOC_EXAMPLE_INPUT)
        assertThat(result).isEqualTo(5)
    }

    @Test
    @Throws(URISyntaxException::class, IOException::class)
    fun testPart2Input() {
        val result = part2(input)
        assertThat(result).isEqualTo(1248) // correct result.
    }

    @get:Throws(URISyntaxException::class, IOException::class)
    val input: Array<Int>
        get() {
            val input =
                Day202101Test::class.java.classLoader.getResource("com/github/afranken/aoc/Day202101-input.txt")
            val lines: MutableList<Int> = mutableListOf()
            File(input.toURI()).forEachLine { lines.add(Integer.valueOf(it)) }
            return lines.toTypedArray()
        }
}
