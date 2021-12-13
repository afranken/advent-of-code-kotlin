package com.github.afranken.aoc

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

internal class Day202108Test {

    private val AOC_EXAMPLE_INPUT = arrayOf(
        "be cfbegad cbdgef fgaecd cgeb fdcge agebfd fecdb fabcd edb | fdgacbe cefdb cefbgd gcbe",
        "edbfga begcd cbg gc gcadebf fbgde acbgfd abcde gfcbed gfec | fcgedb cgb dgebacf gc",
        "fgaebd cg bdaec gdafb agbcfd gdcbef bgcad gfac gcb cdgabef | cg cg fdcagb cbg",
        "fbegcd cbd adcefb dageb afcb bc aefdc ecdab fgdeca fcdbega | efabcd cedba gadfec cb",
        "aecbfdg fbg gf bafeg dbefa fcge gcbea fcaegb dgceab fcbdga | gecf egdcabf bgf bfgea",
        "fgeab ca afcebg bdacfeg cfaedg gcfdb baec bfadeg bafgc acf | gebdcfa ecba ca fadegcb",
        "dbcfg fgd bdegcaf fgec aegbdf ecdfab fbedc dacgb gdcebf gf | cefg dcbef fcge gbcadfe",
        "bdfegc cbegaf gecbf dfcage bdacg ed bedf ced adcbefg gebcd | ed bcgafe cdgba cbgef",
        "egadfb cdbfeg cegd fecab cgb gbdefca cg fgcdab egfdb bfceg | gbdfcae bgc cg cgb",
        "gcafb gcf dcaebfg ecagb gf abcdeg gaef cafbge fdbac fegbdc | fgae cfgab fg bagce"
    )

    private val input: Array<String>
        get() {
            return getInput("com/github/afranken/aoc/Day202108-input.txt")
        }

    @Test
    fun testPart1Example() {
        val result = Day202108.part1(AOC_EXAMPLE_INPUT)
        Assertions.assertThat(result).isEqualTo(26)
    }

    @Test
    fun testPart1Input() {
        val result = Day202108.part1(input)
        Assertions.assertThat(result).isEqualTo(421)
    }

    @Test
    fun testPart2Example() {
        val result = Day202108.part2(AOC_EXAMPLE_INPUT)
        Assertions.assertThat(result).isEqualTo(61229)
    }

    @Test
    fun testPart2Input() {
        val result = Day202108.part2(input)
        Assertions.assertThat(result).isEqualTo(986163)
    }
}
