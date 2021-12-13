package com.github.afranken.aoc

object Day202108 {

    fun part1(inputs: Array<String>): Int {
        val input = convert(inputs)
        var count = 0

        input.forEach {
            it.second.forEach {
                when (it.length) {
                    2 -> count++ // 1
                    4 -> count++ // 4
                    3 -> count++ // 7
                    7 -> count++ // 8
                }
            }
        }

        return count
    }

    fun part2(inputs: Array<String>): Int {
        val input = convert(inputs)

        return input.sumOf {  (input, output) ->
            randomConfig(input, output)
         }
    }

    /**
     * Took this from Sebastian's solution after many tries of implementing this myself.
     * Kudos!
     *
     * https://github.com/SebastianAigner
     */
    private val segmentsToDigits = mapOf(
        setOf(0, 1, 2, 4, 5, 6) to 0,
        setOf(2, 5) to 1,
        setOf(0, 2, 3, 4, 6) to 2,
        setOf(0, 2, 3, 5, 6) to 3,
        setOf(1, 2, 3, 5) to 4,
        setOf(0, 1, 3, 5, 6) to 5,
        setOf(0, 1, 3, 4, 5, 6) to 6,
        setOf(0, 2, 5) to 7,
        setOf(0, 1, 2, 3, 4, 5, 6) to 8,
        setOf(0, 1, 2, 3, 5, 6) to 9
    )

    private fun randomConfig(words: List<String>, expectedNumbers: List<String>): Int {
        val inputCables = 0..6
        val inputChars = 'a'..'g'
        fun getMapping(): Map<Char, Int> {
            permute@ while (true) {
                val perm = inputChars.zip(inputCables.shuffled()).toMap()
                for (word in words) {
                    val mapped = word.map { perm[it]!! }.toSet()
                    val isValidDigit = segmentsToDigits.containsKey(mapped)
                    if (!isValidDigit) continue@permute
                }
                return perm
            }
        }

        val mapping = getMapping()
        val num = expectedNumbers.joinToString("") { digit ->
            val segments = digit.map { mapping[it]!! }.toSet()
            val dig = segmentsToDigits[segments]!!
            "$dig"
        }
        return num.toInt()
    }

    private fun convert(inputs: Array<String>): List<Pair<List<String>, List<String>>> {
        return inputs.map{
            val (part1, part2) = it.split(" | ")
            val signals = part1.split(" ")
            val digits = part2.split(" ")
            Pair(signals, digits)
        }
    }
}
