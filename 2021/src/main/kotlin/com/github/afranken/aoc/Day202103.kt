package com.github.afranken.aoc

import kotlin.math.pow

object Day202103 {

    fun part1(inputs: Array<String>): Int {
        //every input is expected to have the same size. Take inputs[0] to initialize.
        val inputLength = inputs[0].length
        val zeroes = IntArray(inputLength)
        val ones = IntArray(inputLength)

        //count up ones and zeroes
        for (input in inputs) {
            for (i in 0 until inputLength) {
                when (input[i].digitToInt()) {
                    0 -> zeroes[i]++
                    1 -> ones[i]++
                }
            }
        }

        val gammaBinary = Array(inputLength){""}
        val epsilonBinary = Array(inputLength){""}

        //construct gamma and epsilon binary numbers
        for (i in 0 until inputLength) {
            if (zeroes[i] > ones[i]) {
                gammaBinary[i] = "0"
                epsilonBinary[i] = "1"
            } else {
                gammaBinary[i] = "1"
                epsilonBinary[i] = "0"
            }
        }

        //convert to String representing binary code, then to decimal
        val gamma = toDecimal(gammaBinary.joinToString(""))
        val epsilon = toDecimal(epsilonBinary.joinToString(""))

        return gamma * epsilon
    }

    fun part2(inputs: Array<String>): Int {
        return 1
    }

    private fun toDecimal(binaryNumber: String): Int {
        var sum = 0
        binaryNumber.reversed().forEachIndexed { k, v ->
            sum += v.toString().toInt() * 2.0.pow(k.toDouble()).toInt()
        }
        return sum
    }
}
