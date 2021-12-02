package com.github.afranken.aoc

object Day202102 {

    fun part1(inputs: Array<String>): Int {
        // Array<Int>[horizontal,depth]
        val dimensions = intArrayOf(0,0)

        for (input in inputs) {
            val splitted = input.split(' ')
            val instruction = splitted[0]
            val value = Integer.valueOf(splitted[1])
            when (instruction) {
                "forward" -> dimensions[0]+=value
                "down" -> dimensions[1]+=value
                "up" -> dimensions[1]-=value
            }
        }

        return dimensions[0] * dimensions[1]
    }

    fun part2(inputs: Array<String>): Int {
        // Array<Int>[horizontal,depth,aim]
        val dimensions = intArrayOf(0,0,0)

        for (input in inputs) {
            val splitted = input.split(' ')
            val instruction = splitted[0]
            val value = Integer.valueOf(splitted[1])
            when (instruction) {
                "forward" -> {
                    dimensions[0]+=value
                    dimensions[1]+=value*dimensions[2]
                }
                "down" -> {
                    dimensions[2]+=value
                }
                "up" -> {
                    dimensions[2]-=value
                }
            }
        }

        return dimensions[0] * dimensions[1]
    }

}
