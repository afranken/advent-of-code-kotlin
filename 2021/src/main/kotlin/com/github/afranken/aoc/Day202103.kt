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

        val gammaBinary = Array(inputLength) { "" }
        val epsilonBinary = Array(inputLength) { "" }

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
        //all inputs are expected to have the same length
        val inputLength = inputs[0].length

        //iterate over initial list

        //split list into 1s and 0s for the first bit position
        val splitted = splitListByBit(inputs, 0)
        var oxygenBinary = if (splitted[1].size >= splitted[0].size) splitted[1] else splitted[0]
        var co2Binary = if (splitted[0].size <= splitted[1].size) splitted[0] else splitted[1]

        //process both lists: larger list for oxygen, smaller list for co2. Given equal size,
        // process 1s for oxygen.
        for (i in 1 until inputLength) {
            if (oxygenBinary.size > 1) {
                //oxygen: go through list for every bit position in 1 until length, always keep the larger list
                val oxygenSplit = splitListByBit(oxygenBinary, i)
                oxygenBinary = findNext(oxygenSplit[1], oxygenSplit[0], true)
            }
            if (co2Binary.size > 1) {
                //co2: go through list for every bit position in 1 until length, always keep smaller list.
                val co2Split = splitListByBit(co2Binary, i)
                co2Binary = findNext(co2Split[1], co2Split[0], false)
            }
        }

        //convert to String representing binary code, then to decimal
        val oxygen = toDecimal(oxygenBinary.joinToString(""))
        val co2 = toDecimal(co2Binary.joinToString(""))

        return oxygen * co2
    }

    private fun findNext(ones: Array<String>, zeroes: Array<String>, oxygen: Boolean): Array<String> {
        return if (oxygen) {
            if (ones.size >= zeroes.size) { //oxygen prefers 1s over 0s when sizes are equal
                ones
            } else {
                zeroes
            }
        } else {
            if (zeroes.size <= ones.size) { //co2 prefers 0s over 1s when sizes are equal
                zeroes
            } else {
                ones
            }
        }
    }

    private fun splitListByBit(inputs: Array<String>, position: Int): Array<Array<String>> {
        val ones = arrayListOf<String>()
        val zeroes = arrayListOf<String>()

        for (input in inputs) {
            val c = input[position].toString()
            when (c) {
                "0" -> zeroes.add(input)
                "1" -> ones.add(input)
            }
        }

        //returns zeroes array with index 0 and ones array with index 1.
        return arrayOf(zeroes.toTypedArray(), ones.toTypedArray())
    }

    private fun toDecimal(binaryNumber: String): Int {
        var sum = 0
        binaryNumber.reversed().forEachIndexed { k, v ->
            sum += v.toString().toInt() * 2.0.pow(k.toDouble()).toInt()
        }
        return sum
    }
}
