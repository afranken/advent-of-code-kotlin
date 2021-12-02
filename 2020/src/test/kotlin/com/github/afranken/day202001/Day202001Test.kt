package com.github.afranken.day202001

import com.github.afranken.day202001.Day202001.NOT_FOUND
import com.github.afranken.day202001.Day202001.computePart1
import org.assertj.core.api.Assertions.assertThat
import java.io.File
import java.io.IOException
import java.net.URISyntaxException
import kotlin.test.Test

object Day202001Test {
    private val AOC_INPUT = listOf(1721, 979, 366, 299, 675, 1456)
    private const val AOC_RESULT = 514579
    private const val TARGET = 2020

    @Test
    @Throws(URISyntaxException::class, IOException::class)
    fun testComputePart1OnRealInput() {
        val result = computePart1(input, TARGET)
        assertThat(result).isNotEqualTo(NOT_FOUND)
        assertThat(result).isEqualTo(788739) // correct result.
    }

    @Test
    fun testComputePart1Success() {
        val result = computePart1(AOC_INPUT.toTypedArray(), TARGET)
        assertThat(result).isEqualTo(AOC_RESULT)
    }

    @Test
    fun testComputePart1NotFound() {
        val result = computePart1(listOf(0, 1).toTypedArray(), TARGET)
        assertThat(result).isEqualTo(NOT_FOUND)
    }

    @get:Throws(URISyntaxException::class, IOException::class)
    val input: Array<Int>
        get() {
            val input =
                Day202001Test::class.java.classLoader.getResource("com/github/afranken/day202001/input.txt")
            val lines: MutableList<Int> = mutableListOf()
            File(input.toURI()).forEachLine { lines.add(Integer.valueOf(it)) }
            return lines.toTypedArray()
        }
}
